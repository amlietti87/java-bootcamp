/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author andreslietti
 */

@Entity
@Table ( name = "ENTITY")
public class Meeting {

    @Id
    @GeneratedValue
    @Column (name = "meeting_id")
    private Long id;

    @OneToOne
    private Attendee attendee;

    @OneToOne
    private Room room;

    @Column (name = "m_date")
    public Date m_date;

    @Column (name = "time_slot")
    public String time_slot;

    public Meeting(Attendee attendee, Room room, Date m_date, String time_slot) {
        this.attendee = attendee;
        this.room = room;
        this.m_date = m_date;
        this.time_slot = time_slot;
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

    public Date getM_date() {
        return m_date;
    }

    public void setM_date(Date m_date) {
        this.m_date = m_date;
    }

    public String getTime_slot() {
        return time_slot;
    }

    public void setTime_slot(String time_slot) {
        this.time_slot = time_slot;
    }
}

