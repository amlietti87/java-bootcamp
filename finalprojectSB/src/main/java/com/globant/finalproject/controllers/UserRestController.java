package com.globant.finalproject.controllers;

import com.globant.finalproject.model.User;
import com.globant.finalproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAnyRole()")
    @RequestMapping(method = GET)
    @ResponseStatus(OK)
    public List<User> getAllUsers(){

        List<User> listUsers = userService.listUsers();
        return listUsers;
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

    @PreAuthorize("hasAnyRole()")
    @RequestMapping(value = "/{id}", method = PUT)
    @ResponseStatus(OK)
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user){
        userService.getUserById(id);
        userService.updateUser(user);
        return user;
    }

    @PreAuthorize("hasAnyRole()")
    @RequestMapping(value = "/{id}", method = DELETE)
    @ResponseStatus(OK)
    public ResponseEntity<String> removeUser(@PathVariable("id") Long id){
        try {
            userService.removeUser(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Deleted ok", OK);
    }

}
