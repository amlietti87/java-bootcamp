package com.globant.finalproject.repositories;

import com.globant.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserName(String userName);
    List<User> findByUserLastname(String userLastname);
    Optional<User>findByUserNick(String userNick);
}
