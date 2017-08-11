package com.globant.meetings.controllers;

import com.globant.meetings.model.Meeting;
import com.globant.meetings.repositories.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
