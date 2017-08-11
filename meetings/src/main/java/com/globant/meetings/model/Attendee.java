package com.globant.meetings.model;

import javax.persistence.*;

@Entity
@Table(name = "attendee")
public class Attendee {

    @Id
    @GeneratedValue
    @Column(name = "attendee_id")
    private Long id;

    @Column(name = "attendee_name")
    public String atttendesName;

    @Column(name = "attendee_lastname")
    public String attendesLastName;


    public Attendee(String attendesName, String attendesLastName) {
        this.atttendesName = attendesName;
        this.attendesLastName = attendesLastName;
    }

    public Attendee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAtttendesName() {
        return atttendesName;
    }

    public void setAtttendesName(String atttendesName) {
        this.atttendesName = atttendesName;
    }

    public String getAttendesLastName() {
        return attendesLastName;
    }

    public void setAttendesLastName(String attendesLastName) {
        this.attendesLastName = attendesLastName;
    }
}
