package com.apirest.apirest.Controllers;

import com.apirest.apirest.Entities.Product;
import com.apirest.apirest.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found product by id: " + id));
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product detailProduct){
        Product product =  productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found product by id: " + id));

        product.setName(detailProduct.getName());
        product.setPrice(detailProduct.getPrice());

        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProducct(@PathVariable Long id){
        Product product =  productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found product by id: " + id));

        productRepository.delete(product);
        return "Product was deleted with id: " + id;
    }
}
