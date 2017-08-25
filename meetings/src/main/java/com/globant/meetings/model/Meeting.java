package com.globant.meetings.model;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.List;

import static org.hibernate.annotations.CascadeType.ALL;

@Entity
@Table( name = "meeting")
public class Meeting {

    @Id
    @GeneratedValue
    @Column(name = "meeting_id")
    private Long id;

    // One meeting may have one or more attendees.
    @OneToMany (mappedBy = "meeting")
    @Cascade(ALL)
    private List<Attendee> attendees;

    @ManyToOne
    private Room room;

    @Column (name = "time_slot")
    public String timeSlot;

    public Meeting(List<Attendee> attendees, Room room, String timeSlot) {
        this.attendees = attendees;
        this.room = room;
        this.timeSlot = timeSlot;
    }

    public Meeting() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
}

