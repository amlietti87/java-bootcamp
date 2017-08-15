package com.globant.finalproject.serviceImpl;

import com.globant.finalproject.model.Category;
import com.globant.finalproject.model.Product;
import com.globant.finalproject.repositories.ProductRepository;
import com.globant.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void removeProduct(Long id) {
        productRepository.delete(id);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public List<Product> findByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findProductsByCategory(category);
    }


}
