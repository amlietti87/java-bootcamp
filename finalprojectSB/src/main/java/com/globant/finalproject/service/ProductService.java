package com.globant.finalproject.service;

import com.globant.finalproject.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProduct();

    void addProduct (final Product product);

    void updateProduct (final Product product);

    void removeProduct (final Long id);

    Product getProductById (final Long id);

    List<Product> findByProduct_name(final String product_name);

    List<Product> findByProductsByCategory(final String category_name);

}
