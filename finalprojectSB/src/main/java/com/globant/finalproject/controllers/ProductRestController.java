package com.globant.finalproject.controllers;

import com.globant.finalproject.model.Category;
import com.globant.finalproject.model.ParamRequest;
import com.globant.finalproject.model.Product;
import com.globant.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
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
    public ResponseEntity<List<Product>> getAllProducts(){

        List<Product> listProducts = productService.listProducts();
        return new ResponseEntity<>(listProducts, OK);
    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    public ResponseEntity<Product> addProduct (@RequestBody Product product){
        if (product.getId()==null){
            productService.addProduct(product);
            return new ResponseEntity<>(product, CREATED);
        }else{
            productService.updateProduct(product);
            return new ResponseEntity<>(product, OK);
        }
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<String> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        Product pro = productService.getProductById(id);
        if (product.getId() == null){
            return new ResponseEntity<>("The product with id "+ product.getId()+ " doesn't exists", NOT_FOUND);
        }
        productService.updateProduct(product);
        return new ResponseEntity<>("Product with id "+ product.getId()+ " was updated", OK);

    }


    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<String> removeProduct(@PathVariable("id") Long id){
        try {
            productService.removeProduct(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Deleted ok", OK);
    }


    @RequestMapping(value = "/search", method = POST)
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

