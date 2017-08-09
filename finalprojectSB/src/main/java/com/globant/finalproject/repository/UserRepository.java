package com.globant.finalproject.repository;

import com.globant.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUser_name(String user_name);
    List<User> findByUser_lastname(String last_name);

}
