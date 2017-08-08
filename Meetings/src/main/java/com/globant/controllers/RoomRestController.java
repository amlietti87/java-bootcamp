/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.controllers;

import com.globant.model.Room;
import com.globant.repositories.RoomRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author andreslietti
 */
@RestController
@RequestMapping("/room")
public class RoomRestController {

    private RoomRepository roomRepository;

    @Autowired
    public RoomRestController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @RequestMapping(value = "/list", method = GET)
    public List<Room> getallRooms(){
        List<Room> listRooms = roomRepository.getAllRooms();
        return listRooms;
    }

    @RequestMapping(value = "/add", method = POST)
    public Room addAttendee(final Room room){
        return roomRepository.save(room);

    }

    @RequestMapping(value = "/remove/{id}")
    public String removeAttendee(final @PathVariable("id") Long id){
        try {
            roomRepository.delete(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



}

