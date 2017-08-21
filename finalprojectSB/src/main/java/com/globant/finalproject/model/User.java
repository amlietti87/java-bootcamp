package com.globant.finalproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;


@Entity
@Table(name = "user")
public class User {

    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_lastname", nullable = false)
    private String userLastname;

    @Column(name = "user_dni", unique = true, nullable = false)
    private String userDni;

    @Column(name = "user_pass", nullable = false)
    private String userPass;

    @Column(name = "user_nick", unique = true, nullable = false)
    private String userNick;

    @Column(name = "user_email", unique = true, nullable = false)
    private String userEmail;

    @Column(name = "user_phonenumber", nullable = false)
    private String userPhoneNumber;

    // if delete a user, delete the cart associated
    @JsonManagedReference(value = "cart-user")
    @OneToOne(mappedBy = "user")
    private Cart cart;

    //Constructors

    public User() {
        // JpaOnly
    }

    public User(User user) {
        this.userName = user.getUserName();
        this.userLastname = user.getUserLastname();
        this.userDni = user.getUserDni();
        this.userPass = user.getUserDni();
        this.userNick = user.getUserNick();
        this.userEmail = user.getUserEmail();
        this.userPhoneNumber = user.getUserPhoneNumber();
    }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getUserDni() {
        return userDni;
    }

    public void setUserDni(String userDni) {
        this.userDni = userDni;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userLastname='" + userLastname + '\'' +
                ", userDni='" + userDni + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userNick='" + userNick + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", cart_id=" + cart.getId() +
                '}';
    }
}

