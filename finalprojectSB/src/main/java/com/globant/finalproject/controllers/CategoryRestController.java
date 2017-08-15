package com.globant.finalproject.controllers;

import com.globant.finalproject.model.Category;
import com.globant.finalproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/category")
public class CategoryRestController {

    private CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/list", method = GET)
    @ResponseStatus(OK)
    public List<Category> getAllCategories(){

        List<Category> listCategories = categoryService.listCategories();
        return listCategories;
    }

    @RequestMapping(value = "/add", method = POST)
    @ResponseStatus(CREATED)
    public Category addCategory (@RequestBody Category category){
        if (category.getId()==null){
            categoryService.addCategory(category);
        }else{
            categoryService.updateCategory(category);
        }
        return category;
    }

    @RequestMapping(value = "/update/{id}", method = POST)
    @ResponseStatus(OK)
    public Category updateCategory(@PathVariable("id") Long id, @RequestBody Category category){
        category.setId(id);
        categoryService.updateCategory(category);
        return category;
    }

    @RequestMapping(value = "/remove/{id}")
    @ResponseStatus(OK)
    public String removeCategory(@PathVariable("id") Long id){
        try {
            categoryService.removeCategory(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/category/list";
    }
}
