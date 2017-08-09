package com.globant.finalproject.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {


    // Fields  and relationship between category and product
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    public String product_Name;

    @Column(name = "product_descrption")
    public String product_Description;

    @Column (name = "product_price")
    public double product_price;

    @ManyToMany
    @JoinTable(name = "products_category",
            joinColumns = @JoinColumn (name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<Category> category;


    // Constructors

    public Product(String product_Name, String product_Description, double product_price) {
        this.product_Name = product_Name;
        this.product_Description = product_Description;
        this.product_price = product_price;
    }

    public Product() {
        // Jpa Only.
    }

    //Getters and Setters

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public String getProduct_Description() {
        return product_Description;
    }

    public void setProduct_Description(String product_Description) {
        this.product_Description = product_Description;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

}

