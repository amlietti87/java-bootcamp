package com.globant.finalproject.service;

import com.globant.finalproject.model.Category;
import com.globant.finalproject.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProducts();

    void addProduct (final Product product);

    void updateProduct (final Product product);

    void removeProduct (final Long id);

    Product getProductById (final Long id);

    List<Product> findByProductName(final String productName);

    List<Product> findByCategory(final Category category);

}
