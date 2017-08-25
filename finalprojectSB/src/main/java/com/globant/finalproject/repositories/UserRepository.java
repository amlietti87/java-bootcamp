package com.globant.finalproject.repositories;

import com.globant.finalproject.model.User;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {



    User findUserByUserEmail(String userEmail);

    User findUserByUserDni(String userDni);

    Optional<User>findByUserNick(String userNick);
}
