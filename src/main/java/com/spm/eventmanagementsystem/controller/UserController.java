package com.spm.eventmanagementsystem.controller;

import com.spm.eventmanagementsystem.dto.LoginDTO;
import com.spm.eventmanagementsystem.dto.UserDTO;
import com.spm.eventmanagementsystem.entity.User;
import com.spm.eventmanagementsystem.response.LoginResponse;
import com.spm.eventmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody UserDTO userDTO){
        String id  =userService.addUser(userDTO);
        return  id;

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}


//NOTES

/*
(Q)what does the ? mean in ;
public ResponseEntity<?> loginUser(LoginDTO loginDTO){
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

In the given code snippet, the `?` in `ResponseEntity<?>` represents a wildcard or an unknown type. It is used when the exact type of the response entity is not known or can vary depending on the context.

In this case, `ResponseEntity<?>` indicates that the response can be of any type. The actual type of the response will be determined at runtime based on the value returned by the `userService.loginUser(loginDTO)` method. It allows for flexibility in handling different types of responses without specifying a specific type upfront.

Using `<?>` can be useful when the specific type of the response is not important or when the code is designed to handle different types of responses in a generic way.

Note that when using `<?>`, it's important to handle the response appropriately based on its actual type to avoid potential type mismatches or runtime errors.
 */