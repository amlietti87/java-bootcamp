/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.repositories;

import com.globant.model.Meeting;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andreslietti
 */
@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    @Query(value = "FROM attendees")
    List<Meeting> getAllMeetings();

}
