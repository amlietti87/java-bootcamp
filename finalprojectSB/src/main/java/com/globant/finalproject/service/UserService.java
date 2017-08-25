package com.globant.finalproject.service;

import com.globant.finalproject.model.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    void addUser ( User user);

    void updateUser ( User user);

    void removeUser ( Long id);

    User getUserById ( Long id);

    User findUserByUserEmail( String userEmail);

    User findUserByUserDni( String userDni);


}
