package com.globant.finalproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.REMOVE;

@Entity
@Table(name = "stock")
public class PStock {

    // Fields and relationship between stock and product. One product have one stock.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stock_id")
    private Long id;

    @Column(name = "stock_quantity", columnDefinition="INT default '0'")
    private int stockQuantity;

    @JsonBackReference(value="stock-product")
    @OneToOne(cascade = ALL)
    @JoinColumn(name="product_id", nullable = false)
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

    @Override
    public String toString() {
        return "PStock{" +
                "id=" + id +
                ", stockQuantity=" + stockQuantity +
                ", product_name=" + product.getId() +
                '}';
    }
}
