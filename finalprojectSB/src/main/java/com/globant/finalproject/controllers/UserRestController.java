package com.globant.finalproject.controllers;

import com.globant.finalproject.model.User;
import com.globant.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = GET)
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> listUsers = userService.listUsers();
        return new ResponseEntity<>(listUsers, OK);
    }

    @RequestMapping(value = "/dni/{dni}", method = GET)
    public ResponseEntity<User> getUserByDni(@PathVariable String dni){

        User user = userService.findUserByUserDni(dni);
        if (user == null) {
            return new ResponseEntity<>((User) null, NO_CONTENT);
        }
        return new ResponseEntity<>(user, OK);
    }

    @RequestMapping(value = "/mail/{mail}", method = GET)
    public ResponseEntity<User> getUserByUserEmail(@PathVariable String mail) {
        User user = userService.findUserByUserEmail(mail);
        if (user == null) {
            return new ResponseEntity<>((User) null, NO_CONTENT);
        }
        return new ResponseEntity<>(user, OK);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity <User> getUserByUserId(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>((User) null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        User user1 = userService.getUserById(id);
        if (user1 == null){
            return new ResponseEntity<>("The user with id "+ user.getId()+ " doesn't exists", NOT_FOUND);
        }
        userService.updateUser(user);
        return new ResponseEntity<>("Product with id "+ user.getId()+ " was updated", OK);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<String> removeUser(@PathVariable("id") Long id){
        try {
            userService.removeUser(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Deleted ok", OK);
    }

}
