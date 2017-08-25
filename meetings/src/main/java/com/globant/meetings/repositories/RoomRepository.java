package com.globant.meetings.repositories;


import com.globant.meetings.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "FROM Room")
    List<Room> getAllRooms();

}
