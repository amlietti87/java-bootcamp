package com.globant.finalproject.controllers;

import com.globant.finalproject.model.User;
import com.globant.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/signup")
public class SingUpRestController {

    private UserService userService;

    @Autowired
    public SingUpRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    public User addUser (@RequestBody User user){
        if (user.getId()==null){
            userService.addUser(user);
        }else{
            userService.updateUser(user);
        }
        return user;
    }
}
