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
@Table (name = "ATTENDEES")
public class Attendee {

    @Id
    @GeneratedValue
    @Column (name = "attendee_id")
    private Long id;

    @Column(name = "attendee_name")
    public String atttendes_name;

    @Column(name = "attendee_lastname")
    public String attendes_lastName;


    public Attendee(String attendes_name, String attendes_lastName) {
        this.atttendes_name = attendes_name;
        this.attendes_lastName = attendes_lastName;
    }

    public Attendee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAtttendes_name() {
        return atttendes_name;
    }

    public void setAtttendes_name(String atttendes_name) {
        this.atttendes_name = atttendes_name;
    }

    public String getAttendes_lastName() {
        return attendes_lastName;
    }

    public void setAttendes_lastName(String attendes_lastName) {
        this.attendes_lastName = attendes_lastName;
    }
}
