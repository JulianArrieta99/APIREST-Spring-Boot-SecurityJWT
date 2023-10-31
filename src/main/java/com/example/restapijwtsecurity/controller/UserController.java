package com.example.restapijwtsecurity.controller;

import com.example.restapijwtsecurity.models.User;
import com.example.restapijwtsecurity.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAllUsers")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/findUserById/{id}")
    public User findUserById(Long id){
        return userService.findUserById(id);
    }

    @GetMapping("/findUserByEmail/{email}")
    public User findUserById(String email){
        return userService.findUserByEmail(email);
    }
    @PostMapping("/saveUser")
    public User saveUser(User user){
        return userService.saveUser(user);
    }
}
