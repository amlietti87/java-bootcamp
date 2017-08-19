package com.globant.finalproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "payment")
public class Payment {


    // Fields an relationship with Cart. One cart has one type of payment.
    @Id
    @GeneratedValue
    @Column(name = "payment_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column (name = "payment_type", nullable = false)
    private String paymentType;

    @Column (name = "amount")
    private double amount;

    // Consutructors.


    public Payment() {
    }

    public Payment(Cart cart, String paymentType, double amount) {
        this.cart = cart;
        this.paymentType = paymentType;
        this.amount = amount;

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", cart_id=" + cart.getId() +
                ", paymentType='" + paymentType + '\'' +
                ", amount=" + amount +
                '}';
    }
}
