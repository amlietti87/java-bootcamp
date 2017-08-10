package com.globant.finalproject.service;

import com.globant.finalproject.model.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    void addUser (final User user);

    void updateUser (final User user);

    void removeUser (final Long id);

    User getUserById (final Long id);

    List<User> findByUserName(final String userName);

    List<User> findByUserLastname(final String userLastname);
}
