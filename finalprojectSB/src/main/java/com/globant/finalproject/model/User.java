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
    public String userName;

    @Column(name = "user_lastname")
    public String userLastname;

    @Column(name = "user_dni")
    public String userDni;

    @Column(name = "user_pass")
    public String userPass;

    @Column(name = "user_nick")
    public String userNick;

    //Constructors

    public User() {
        // JpaOnly
    }

    public User(String userName, String userLastname, String userDni, String userPass, String userNick) {
        this.userName = userName;
        this.userLastname = userLastname;
        this.userDni = userDni;
        this.userPass = userPass;
        this.userNick = userNick;
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
}

