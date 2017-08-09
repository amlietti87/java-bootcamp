package com.globant.finalproject.serviceImpl;

import com.globant.finalproject.model.Product;
import com.globant.finalproject.repository.ProductRepository;
import com.globant.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listProduct() {
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
    public List<Product> findByProduct_name(String product_name) {
        return productRepository.findByProduct_Name(product_name);
    }

    @Override
    public List<Product> findByProductsByCategory(String category_name) {
        return productRepository.findProductsByCategory(category_name);
    }
}
