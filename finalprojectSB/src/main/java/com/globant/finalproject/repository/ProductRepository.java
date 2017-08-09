package com.globant.finalproject.repository;

import com.globant.finalproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProduct_Name(String product_name);
    List<Product> findProductsByCategory(String category_name);

}
