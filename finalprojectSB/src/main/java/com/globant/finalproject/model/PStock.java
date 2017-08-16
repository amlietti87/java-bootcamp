package com.globant.finalproject.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
@Table(name = "stock")
public class PStock {

    // Fields and relationship between stock and product. One product have one stock.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stock_id")
    private Long id;

    @Column(name = "stock_quantity")
    public int stockQuantity;

    @OneToOne
    private Product product;

    // Cosntructors


    public PStock(int stockQuantity, Product product) {
        this.stockQuantity = stockQuantity;
        this.product = product;
    }

    public PStock() {
        //Jps Only
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
