package com.globant.finalproject.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {


    // Fields.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    public String categoryName;


    // Constructors


    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category() {
        // Jpa Only.
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String category_name) {
        this.categoryName = category_name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}


