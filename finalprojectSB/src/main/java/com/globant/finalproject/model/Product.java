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
    public String productName;

    @Column(name = "product_descrption")
    public String productDescription;

    @Column (name = "product_price")
    public double productPrice;

    @ManyToMany
    @JoinTable(name = "products_category",
            joinColumns = @JoinColumn (name = "product_id", referencedColumnName = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Set<Category> category;


    // Constructors

    public Product(String productName, String productDescription, double productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public Product() {
        // Jpa Only.
    }

    //Getters and Setters

    public String getProductName() {
        return productName;
    }

    public void setProduct_Name(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
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

