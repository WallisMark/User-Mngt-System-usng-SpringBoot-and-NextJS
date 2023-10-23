package com.first.usermgntsystem.controller;

import com.first.usermgntsystem.model.UserModel;
import com.first.usermgntsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public UserModel saveUser(@RequestBody UserModel userModel){
        return userService.saveUser(userModel);
    }
    @GetMapping("/users")
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable("id") long id) {
        UserModel userModel = userService.getUserById(id);

        if (userModel != null) {
            return new ResponseEntity<>(userModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}


















