package com.globant.finalproject.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {


    // Fields and relationship between cart and items.
    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    private Long id;

    @OneToMany
    private Set<Item> items;

    //Constructors


    public Cart(Set<Item> items) {
        this.items = items;
    }

    public Cart() {
        //Jpa Only.
    }

    // Getters and Setters


    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
