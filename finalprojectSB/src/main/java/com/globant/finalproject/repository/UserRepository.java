package com.globant.finalproject.repository;

import com.globant.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUser_name(String user_name);
    List<User> findByUser_lastname(String last_name);

}
