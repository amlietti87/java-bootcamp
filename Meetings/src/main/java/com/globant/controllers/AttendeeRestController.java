/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.controllers;

import com.globant.model.Attendee;
import com.globant.repositories.AttendeeRepository;
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
@RequestMapping("/attendees")
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
    public Attendee addAttendee(final Attendee attendee){
        return attendeeRepository.save(attendee);

    }

    @RequestMapping(value = "/remove/{id}")
    public String removeAttendee(final @PathVariable("id") Long id){

        attendeeRepository.delete(id);

        return "redirect:/attendee/list";
    }




}

