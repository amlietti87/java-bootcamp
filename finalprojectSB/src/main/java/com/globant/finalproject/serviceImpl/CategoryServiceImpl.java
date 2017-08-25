package com.globant.finalproject.serviceImpl;

import com.globant.finalproject.model.Category;
import com.globant.finalproject.repositories.CategoryRepository;
import com.globant.finalproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void removeCategory(Long id) {
        categoryRepository.delete(id);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public List<Category> findByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

}
