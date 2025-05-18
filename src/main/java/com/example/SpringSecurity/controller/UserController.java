package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user){
       return service.register(user);
    }

}
