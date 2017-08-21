package com.globant.finalproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import static javax.persistence.CascadeType.REMOVE;

@Entity
@Table(name = "shop")
public class Shop {

    //Fields and relationship between product and item. One Shop is one product.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shop_id")
    private Long id;

    @Column(name = "shop_quantity", columnDefinition = "INT default '0'")
    public int shopQuantity;

    @JsonBackReference(value="shop-product")
    @OneToOne(cascade = REMOVE)
    @JoinColumn(name = "Product_id", nullable = false)
    private Product product;

    @JsonBackReference(value="cart-shops")
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    //Contructors


    public Shop(int shopQuantity, Product product, Cart cart) {
        this.shopQuantity = shopQuantity;
        this.product = product;
        this.cart = cart;
    }

    public Shop() {
        //Jpa Only.
    }

    //Getters and Setters.


    public int getShopQuantity() {
        return shopQuantity;
    }

    public void setShopQuantity(int shopQuantity) {
        this.shopQuantity = shopQuantity;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", shopQuantity=" + shopQuantity +
                ", product=" + product +
                ", cart_id=" + cart.getId() +
                '}';
    }
}
