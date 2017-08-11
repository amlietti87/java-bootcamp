package com.globant.meetings.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "meeting")
public class Meeting {

    @Id
    @GeneratedValue
    @Column(name = "meeting_id")
    private Long id;

    @OneToOne
    private Attendee attendee;

    @OneToOne
    private Room room;

    @Column (name = "time_slot")
    public String timeSlot;

    public Meeting(Attendee attendee, Room room, Date mDate, String timeSlot) {
        this.attendee = attendee;
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

    public Attendee getAttendee() {
        return attendee;
    }

    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
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

