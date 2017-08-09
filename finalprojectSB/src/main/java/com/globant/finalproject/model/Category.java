package com.globant.finalproject.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {


    // Fields.
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    public String category_name;

    @Column(name = "category_description")
    public String category_description;


    // Constructors

    public Category(String category_name, String category_description) {
        this.category_name = category_name;
        this.category_description = category_description;

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

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_description() {
        return category_description;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }

}

