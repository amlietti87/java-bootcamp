package com.globant.meetings.repositories;

import com.globant.meetings.model.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {

    @Query(value = "FROM Attendee")
    List<Attendee> getAllAttendees();

}
