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
    public int itemQuantity;

    @OneToOne
    private Product product;

    //Contructors


    public Item(int itemQuantityuantity, Product product) {
        this.itemQuantity = itemQuantity;
        this.product = product;
    }

    public Item() {
        //Jpa Only.
    }

    //Getters and Setters.

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemQuantity=" + itemQuantity +
                '}';
    }
}
