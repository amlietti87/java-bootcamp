package com.globant.finalproject.controllers;

import com.globant.finalproject.model.Category;
import com.globant.finalproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/category")
public class CategoryRestController {

    private CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = GET)
    public ResponseEntity<List<Category>> getAllCategories(){

        List<Category> listCategories = categoryService.listCategories();

        return new ResponseEntity<>(listCategories, OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<Category> addCategory (@RequestBody Category category){
        if (category.getId()==null){
            categoryService.addCategory(category);
            return new ResponseEntity<>(category,CREATED);
        }else{
            categoryService.updateCategory(category);
            return new ResponseEntity<>(category, OK);
        }

    }


    @RequestMapping(value = "{id}", method = PUT)
    public ResponseEntity<String> updateCategory(@PathVariable("id") Long id, @RequestBody Category category){
        Category cat = categoryService.getCategoryById(id);
        if (cat == null){
           return new ResponseEntity<>("The category with id "+ category.getId()+ " doesn't exists", NOT_FOUND);
       }
        categoryService.updateCategory(category);
       return new ResponseEntity<>("Category with id "+ category.getId()+ " was updated", OK);

    }


    @RequestMapping(value = "{id}", method = DELETE)
    public ResponseEntity <String> removeCategory(@PathVariable("id") Long id){
        try {
            categoryService.getCategoryById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Category deleted ok", OK);
    }
}
