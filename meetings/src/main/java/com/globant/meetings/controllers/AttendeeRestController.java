package com.globant.meetings.controllers;


import com.globant.meetings.model.Attendee;
import com.globant.meetings.repositories.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/attendee")
public class AttendeeRestController {

    private final AttendeeRepository attendeeRepository;

    @Autowired
    public AttendeeRestController(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @RequestMapping(value = "/list", method = GET)
    public List<Attendee> getAllAttendees(){

        List<Attendee> listAttendes = attendeeRepository.getAllAttendees();
        return listAttendes;

    }

    @RequestMapping(value = "/add", method = POST)
    public Attendee addAttendee(@RequestBody Attendee attendee){
        return attendeeRepository.save(attendee);

    }

    @RequestMapping(value = "/remove/{id}")
    public String removeAttendee(final @PathVariable("id") Long id){

        attendeeRepository.delete(id);

        return "redirect:/attendee/list";
    }
}
