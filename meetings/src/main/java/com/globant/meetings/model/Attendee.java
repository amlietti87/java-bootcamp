package com.globant.meetings.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import static org.hibernate.annotations.CascadeType.DELETE;
import static org.hibernate.annotations.CascadeType.PERSIST;
import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

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

    @ManyToOne
    private Meeting meeting;


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

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    @Override
    public String toString() {
        return "Attendee{" +
                "id=" + id +
                ", attendeName='" + attendeName + '\'' +
                ", attendeLastName='" + attendeLastName + '\'' +
                ", meeting=" + meeting +
                '}';
    }
}
