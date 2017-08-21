package com.globant.finalproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table (name = "payment")
public class Payment {


    // Fields an relationship with Cart. One cart has one type of payment.
    @Id
    @GeneratedValue
    @Column(name = "payment_id")
    private Long id;

    @JsonBackReference(value = "cart-payment")
    @OneToOne(cascade = CascadeType.REMOVE)
    private Cart cart;

    @Column (name = "payment_type", nullable = false)
    private String paymentType;

    @Column (name = "amount", columnDefinition = "Decimal(10,2) default '0.00'")
    public double totalAmount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "date", columnDefinition = "DATE", nullable = false)
    private Date paymentDate = new Date();

    // Consutructors.


    public Payment() {
    }

    public Payment(Cart cart, String paymentType, double amount) {
        this.cart = cart;
        this.paymentType = paymentType;
        this.totalAmount = amount;

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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", cart_id=" + cart.getId() +
                ", paymentType='" + paymentType + '\'' +
                ", totalAmount=" + totalAmount +
                ", date=" + paymentDate +
                '}';
    }
}
