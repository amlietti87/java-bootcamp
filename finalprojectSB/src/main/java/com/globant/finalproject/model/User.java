package com.globant.finalproject.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

import static org.hibernate.annotations.CascadeType.ALL;

@Entity
@Table(name = "user")
public class User {

    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    // One user may have one or more carts.
    @OneToMany (mappedBy = "user")
    @Cascade(ALL)
    private List<Cart> carts;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userLastname='" + userLastname + '\'' +
                ", userDni='" + userDni + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userNick='" + userNick + '\'' +
                '}';
    }
}

