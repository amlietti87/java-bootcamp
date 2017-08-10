package com.globant.finalproject.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    //Fields
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    public String user_name;

    @Column(name = "user_lastname")
    public String user_lastname;

    @Column(name = "user_dni")
    public String user_dni;

    @Column(name = "user_pass")
    public String user_pass;

    @Column(name = "user_nick")
    public String user_nick;

    //Constructors

    public User(String user_name, String user_lastname, String user_dni, String user_pass, String user_nick) {
        this.user_name = user_name;
        this.user_lastname = user_lastname;
        this.user_dni = user_dni;
        this.user_pass = user_pass;
        this.user_nick = user_nick;
    }

    public User() {

        //Jpa Only.
    }

    //Getters and Setters

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public String getUser_dni() {
        return user_dni;
    }

    public void setUser_dni(String user_dni) {
        this.user_dni = user_dni;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_nick() {
        return user_nick;
    }

    public void setUser_nick(String user_nick) {
        this.user_nick = user_nick;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

