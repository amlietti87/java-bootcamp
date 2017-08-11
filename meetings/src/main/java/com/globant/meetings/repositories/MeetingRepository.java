package com.globant.meetings.repositories;

import com.globant.meetings.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    @Query(value = "FROM Meeting")
    List<Meeting> getAllMeetings();

}
