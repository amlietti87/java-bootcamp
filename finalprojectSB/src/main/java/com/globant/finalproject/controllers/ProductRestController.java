package com.globant.finalproject.controllers;

import com.globant.finalproject.model.Category;
import com.globant.finalproject.model.Product;
import com.globant.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }



    @RequestMapping(value = "/list", method = GET)
    @ResponseStatus(OK)
    public List<Product> getAllProducts(){

        List<Product> listProducts = productService.listProducts();
        return listProducts;
    }

    @RequestMapping(value = "/add", method = POST)
    @ResponseStatus(CREATED)
    public Product addProduct (@RequestBody Product product){
        if (product.getId()==null){
            productService.addProduct(product);
        }else{
            productService.updateProduct(product);
        }
        return product;
    }

    @RequestMapping(value = "/update/{id}", method = POST)
    @ResponseStatus(OK)
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        productService.getProductById(id);
        productService.updateProduct(product);
        return product;
    }

    @RequestMapping(value = "/remove/{id}")
    @ResponseStatus(OK)
    public String removeProduct(@PathVariable("id") Long id){
        try {
            productService.removeProduct(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/category/list";
    }

    @RequestMapping(value = "/searchbyname/{productName}")
    @ResponseStatus(FOUND)
    public List<Product> findByName(@PathVariable String productName){
        return productService.findByProductName(productName);
    }

    @RequestMapping(value = "searchbycategory", method = POST)
    @ResponseStatus(FOUND)
    public List<Product> findByCategory(@RequestBody Category category){
        return productService.findByCategory(category);
    }   
}

