package com.globant.finalproject.model;

import javax.persistence.*;
import javax.validation.groups.ConvertGroup;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {


    // Fields and relationship between cart and items.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Long id;

    @OneToMany
    private List<Item> items;

    // One or more carts belong to one user
    @OneToOne
    private User user;

    @Column(name = "paid")
    private int paid = 0;

    //Constructors

    public Cart() {
        //JpaOnly
    }

    public Cart(List<Item> items) {
        this.items = items;
    }

    // Getters and Setters


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal(){
        double total = 0;
        for (Item item: items) {
            total += item.getProduct().getProductPrice() * item.getItemQuantity();
        }

        return total;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", items=" + items +
                ", user=" + user +
                ", paid=" + paid +
                '}';
    }
}
