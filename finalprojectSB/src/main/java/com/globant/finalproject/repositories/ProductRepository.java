package com.globant.finalproject.repositories;

import com.globant.finalproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductName(String productName);

    @Query("Select p from Product p inner join p.category c where c in (?1)")
    List<Product> findProductsByCategory(String category);

    Product findProductsByShopId(Long shopID);

}
