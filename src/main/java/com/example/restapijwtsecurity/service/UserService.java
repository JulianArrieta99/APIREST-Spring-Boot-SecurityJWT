package com.example.restapijwtsecurity.service;

import com.example.restapijwtsecurity.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    Optional<User> findUserById(Long id);
    Optional<User> findUserByEmail(String email);
    User saveUser(User user);
}
