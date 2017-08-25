package com.globant.meetings.model;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.List;

import static org.hibernate.annotations.CascadeType.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "room_id")
    private Long id;

    @Column (name = "room_number")
    public int roomNumber;

    @Column (name = "room_name")
    public String roomName;

    @OneToMany(mappedBy = "room")
    @Cascade(ALL)
    private List<Meeting> meetings;



    public Room(int roomNumber, String roomName) {
        this.roomNumber = roomNumber;
        this.roomName = roomName;
    }

    public Room() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", roomName='" + roomName + '\'' +
                ", meetings=" + meetings +
                '}';
    }
}


