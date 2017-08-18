package com.globant.finalproject.model;

import javax.persistence.*;

@Entity
@Table (name = "payment")
public class Payment {


    // Fields an relationship with Cart. One cart has one type of payment.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private Long id;

    @OneToOne
    private Cart cart;

    @Column
    private String paymentType;

    // Consutructors.


    public Payment() {
    }

    public Payment(Cart cart) {
        this.cart = cart;
    }


    // Getters and Setters

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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
