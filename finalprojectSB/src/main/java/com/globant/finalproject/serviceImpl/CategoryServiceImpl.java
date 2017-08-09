package com.globant.finalproject.serviceImpl;

import com.globant.finalproject.model.Category;
import com.globant.finalproject.repository.CategoryRepository;
import com.globant.finalproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategory() {
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
    public Category getById(Long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public List<Category> findByCategory_name(String category_name) {
        return categoryRepository.findByCategory_name(category_name);
    }
}
