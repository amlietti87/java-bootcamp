package com.globant.finalproject.serviceImpl;

import com.globant.finalproject.model.User;
import com.globant.finalproject.repositories.UserRepository;
import com.globant.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        user.setUserPass(passwordEncoder.encode(user.getUserPass()));
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findUserByUserEmail(String userEmail) {
        return userRepository.findUserByUserEmail(userEmail);
    }

    @Override
    public User findUserByUserDni(String userDni) {
        return userRepository.findUserByUserDni(userDni);
    }

}
