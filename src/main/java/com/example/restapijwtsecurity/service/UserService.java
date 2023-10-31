package com.example.restapijwtsecurity.service;

import com.example.restapijwtsecurity.models.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(Long id);
    User findUserByEmail(String email);
    User saveUser(User user);
}
