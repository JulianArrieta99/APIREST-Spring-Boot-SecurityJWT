package com.example.restapijwtsecurity.service.impl;

import com.example.restapijwtsecurity.models.Role;
import com.example.restapijwtsecurity.models.User;
import com.example.restapijwtsecurity.repository.UserRepository;
import com.example.restapijwtsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        if(user.getRole() == null){
            user.setRole(Role.USER);
        }
        return userRepository.save(user);
    }
}
