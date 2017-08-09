package com.globant.finalproject.model;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    //Fields and relationship between product and item. One Item is one product.
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_quantity")
    public int item_quantity;

    @OneToOne
    private Product product;

    //Contructors


    public Item(int item_quantity, Product product) {
        this.item_quantity = item_quantity;
        this.product = product;
    }

    public Item() {
        //Jpa Only.
    }

    //Getters and Setters.

    public int getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
