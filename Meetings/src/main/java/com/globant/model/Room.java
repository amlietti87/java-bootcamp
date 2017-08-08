/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author andreslietti
 */
@Entity
@Table(name = "ROOMS")
public class Room {

    @Id
    @GeneratedValue
    @Column (name = "room_id")
    private Long id;

    @Column (name = "room_number")
    public int room_number;

    @Column (name = "room_name")
    public String room_name;

    public Room(int room_number, String room_name) {
        this.room_number = room_number;
        this.room_name = room_name;
    }

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }
}

