package com.globant.finalproject.repositories;

import com.globant.finalproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByCategory_name(String category_name);
}
