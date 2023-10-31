package com.example.restapijwtsecurity.security;

import com.example.restapijwtsecurity.controller.auth.dto.LoginRequest;
import com.example.restapijwtsecurity.controller.auth.dto.LoginResponse;
import com.example.restapijwtsecurity.controller.auth.dto.RegisterRequest;
import com.example.restapijwtsecurity.controller.auth.dto.RegisterResponse;
import com.example.restapijwtsecurity.models.Role;
import com.example.restapijwtsecurity.models.User;
import com.example.restapijwtsecurity.repository.UserRepository;
import com.example.restapijwtsecurity.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public RegisterResponse register(RegisterRequest request){
        User user = User.builder().firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
    return RegisterResponse.builder().token(jwtToken).build();
    }

    public LoginResponse login(LoginRequest request){
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    User user = userRepository.findUserByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return LoginResponse.builder().token(jwtToken).build();
    }
}
