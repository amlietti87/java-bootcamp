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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //Constructors

    public Cart() {
        //JpaOnly
    }

    public Cart(List<Item> items, User user) {
        this.items = items;
        this.user = user;
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

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", items=" + items +
                ", user=" + user +
                '}';
    }
}
