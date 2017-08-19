package com.globant.finalproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {


    // Fields and relationship between cart and shops.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Long id;

    @JsonManagedReference(value = "cart-shops")
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    private List<Shop> shops;

    // One user has carts belong to one user
    @OneToOne
    @JsonBackReference(value = "cart-user")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "paid", nullable = false)
    private int paid = 0;

    @JsonIgnore
    @OneToOne(mappedBy = "cart", cascade = CascadeType.REMOVE)
    private Payment payment;

    //Constructors

    public Cart() {
        //JpaOnly
    }

    public Cart(User user, int paid) {
        this.user = user;
        this.paid = paid;

    }

    // Getters and Setters


    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", shops=" + shops +
                ", user=" + user +
                ", paid=" + paid +
                '}';
    }

    @JsonIgnore
    public double getTotal(){
        double total = 0;
        for (Shop shop : shops) {
            total += shop.getProduct().getProductPrice() * shop.getShopQuantity();
        }

        return total;
    }

    @JsonIgnore
    public Shop getCheapestitem() {
        Comparator<Shop> comparatorItem = (item1,
                                           item2) -> item1.getProduct().getProductPrice() < item2.getProduct().productPrice ? 1 : -1;
        return shops.stream().max(comparatorItem).orElse(null);
    }
}
