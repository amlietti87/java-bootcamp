package com.globant.finalproject.repositories;

import com.globant.finalproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductName(String productName);

    //@Query(value = "SELECT p FROM Product p WHERE p.category.name = :name")
    List<Product> findProductsByCategory(@Param("name") String categoryName);

}
