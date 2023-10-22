package com.first.usermgntsystem.controller;

import com.first.usermgntsystem.model.UserModel;
import com.first.usermgntsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public UserModel saveUser(@RequestBody UserModel userModel){
        return userService.saveUser(userModel);
    }
}
