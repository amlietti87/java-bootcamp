package com.globant.finalproject.service;

import com.globant.finalproject.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> listCategory();

    void addCategory (final Category category);

    void updateCategory (final Category category);

    void removeCategory (final Long id);

    Category getById (final Long id);

    List<Category> findByCategoryName (final String categoryName);
}

