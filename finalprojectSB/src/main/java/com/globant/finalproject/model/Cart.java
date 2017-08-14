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

    @OneToOne
    private User user;

    //Constructors

    public Cart() {
        //JpaOnly
    }

    public Cart(Set<Item> items, User user) {
        this.items = items;
        this.user = user;
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
