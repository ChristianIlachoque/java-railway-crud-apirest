package com.apirest.apirest.Repositories;

import com.apirest.apirest.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
