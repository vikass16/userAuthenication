package com.security.controller;

import com.security.model.Users;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;  // service is object of UserService

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return service.register(user);  // this service method autowired from
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return service.verify(user);
    }

}
