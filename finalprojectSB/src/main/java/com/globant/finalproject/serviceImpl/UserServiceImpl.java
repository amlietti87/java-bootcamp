package com.globant.finalproject.serviceImpl;

import com.globant.finalproject.model.User;
import com.globant.finalproject.repository.UserRepository;
import com.globant.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
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
        return userRepository.getOne(id);
    }

    @Override
    public List<User> findByUser_name(String user_name) {
        return userRepository.findByUser_name(user_name);
    }

    @Override
    public List<User> findByUser_lastname(String last_name) {
        return userRepository.findByUser_lastname(last_name);
    }
}
