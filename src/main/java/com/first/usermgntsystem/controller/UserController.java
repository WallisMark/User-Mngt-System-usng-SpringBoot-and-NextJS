package com.first.usermgntsystem.controller;

import com.first.usermgntsystem.model.UserModel;
import com.first.usermgntsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public ResponseEntity<UserModel> getUserById(@PathVariable("id") Long id) {
        UserModel userModel = userService.getUserById(id);

        if (userModel != null) {
            return new ResponseEntity<>(userModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")

    public ResponseEntity<Map<String,Boolean>> deleteUser (@PathVariable("id") Long id){
        boolean deleted = false;
        deleted = userService.deleteUser(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("delete",deleted);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/users/{id}")

    public ResponseEntity<UserModel> updateUser (@PathVariable("id") Long id, @RequestBody UserModel userModel){
        userModel = userService.updateUser(id,userModel);
        return ResponseEntity.ok(userModel);
    }
}


















