package com.globant.finalproject.repositories;

import com.globant.finalproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductName(String productName);
    //List<Product> findProductsByCategoryName(String categoryName);

}
