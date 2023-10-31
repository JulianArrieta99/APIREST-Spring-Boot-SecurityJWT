package com.example.restapijwtsecurity.service.impl;

import com.example.restapijwtsecurity.errors.UserNotFoundException;
import com.example.restapijwtsecurity.models.User;
import com.example.restapijwtsecurity.repository.UserRepository;
import com.example.restapijwtsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No se encontró el usuario con ID: " + id));
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException("No se encontró el usuario con el email: " + email));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
