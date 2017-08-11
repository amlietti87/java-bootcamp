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
    public String attendeName;

    @Column(name = "attendee_lastname")
    public String attendeLastName;


    public Attendee() {

    }

    public Attendee(String attendeName, String attendeLastName) {
        this.attendeName = attendeName;
        this.attendeLastName = attendeLastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttendeName() {
        return attendeName;
    }

    public void setAttendeName(String attendeName) {
        this.attendeName = attendeName;
    }

    public String getAttendeLastName() {
        return attendeLastName;
    }

    public void setAttendeLastName(String attendeLastName) {
        this.attendeLastName = attendeLastName;
    }
}
