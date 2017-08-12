package com.globant.meetings.controllers;


import com.globant.meetings.model.Attendee;
import com.globant.meetings.repositories.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(path = "/attendee")
public class AttendeeRestController {

    private final AttendeeRepository attendeeRepository;

    @Autowired
    public AttendeeRestController(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @RequestMapping(value = "/list", method = GET)
    @ResponseStatus(OK)
    public List<Attendee> getAllAttendees(){

        List<Attendee> listAttendes = attendeeRepository.getAllAttendees();
        return listAttendes;

    }

    @RequestMapping(value = "/add", method = POST)
    @ResponseStatus(CREATED)
    public Attendee addAttendee(@RequestBody Attendee attendee){
        return attendeeRepository.save(attendee);

    }

    @RequestMapping(value = "/remove/{id}")
    @ResponseStatus(OK)
    public Attendee removeAttendee(final @PathVariable("id") Long id){

        attendeeRepository.delete(id);

        return null;
    }
}
