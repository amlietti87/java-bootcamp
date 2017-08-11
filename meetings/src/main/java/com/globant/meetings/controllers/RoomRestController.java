package com.globant.meetings.controllers;

import com.globant.meetings.model.Room;
import com.globant.meetings.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
    public Room addRoom(final @ModelAttribute("room") Room room){
        return roomRepository.save(room);

    }

    @RequestMapping(value = "/remove/{id}")
    public String removeRoom(final @PathVariable("id") Long id){
        try {
            roomRepository.delete(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

