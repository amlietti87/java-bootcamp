/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.controllers;

import com.globant.model.Meeting;
import com.globant.repositories.MeetingRepository;
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
@RequestMapping("/meeting")
public class MeetingRestController {

    private final MeetingRepository meetingRepository;

    @Autowired
    public MeetingRestController(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @RequestMapping(value = "/list", method = GET)
    public List<Meeting> getAllMeetings(){
        List<Meeting> listMeetings = meetingRepository.getAllMeetings();
        return listMeetings;
    }

    @RequestMapping(value = "/add", method = POST)
    public Meeting addMeeting(final Meeting meeting){
         return meetingRepository.save(meeting);

    }

    @RequestMapping(value = "/remove/{id}")
    public Meeting removeMeeting(final @PathVariable("id") Long id){
        try {
            meetingRepository.delete(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/edit/{id}")
    public Meeting editMeeting(final @PathVariable("id") Long id){
        return meetingRepository.findOne(id);
    }
}

