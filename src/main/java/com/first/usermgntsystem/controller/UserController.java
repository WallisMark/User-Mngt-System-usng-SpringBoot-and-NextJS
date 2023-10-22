package com.first.usermgntsystem.controller;

import com.first.usermgntsystem.entity.User;
import com.first.usermgntsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    public User saveUser (@RequestBody User user){
        return userService.saveUser(user);
    }
}
