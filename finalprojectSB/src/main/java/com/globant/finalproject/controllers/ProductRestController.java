package com.globant.finalproject.controllers;

import com.globant.finalproject.model.ParamRequest;
import com.globant.finalproject.model.Product;
import com.globant.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = GET)
    @ResponseStatus(OK)
    public List<Product> getAllProducts(){

        List<Product> listProducts = productService.listProducts();
        return listProducts;
    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    public Product addProduct (@RequestBody Product product){
        if (product.getId()==null){
            productService.addProduct(product);
        }else{
            productService.updateProduct(product);
        }
        return product;
    }

    @RequestMapping(value = "/{id}", method = PUT)
    @ResponseStatus(OK)
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        productService.getProductById(id);
        productService.updateProduct(product);
        return product;
    }


    @RequestMapping(value = "/{id}", method = DELETE)
    @ResponseStatus(OK)
    public ResponseEntity<String> removeProduct(@PathVariable("id") Long id){
        try {
            productService.removeProduct(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Deleted ok", OK);
    }


    @RequestMapping(value = "/search", method = POST)
    @ResponseStatus(OK)
    public List<Product> findByName(@RequestBody ParamRequest request){
        if (request.getType().equals(ParamRequest.SearchType.PR)) {
            if(request.getSearchParam().length() == 0) {
                throw new MyException("cannot send products with length 0");
            }
            return productService.findByProductName(request.getSearchParam());
        }

        return productService.findByCategory(request.getSearchParam());
    }

}

