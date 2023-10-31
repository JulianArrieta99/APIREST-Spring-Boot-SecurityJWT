package com.example.restapijwtsecurity.controller.auth;

import com.example.restapijwtsecurity.controller.auth.dto.LoginRequest;
import com.example.restapijwtsecurity.controller.auth.dto.LoginResponse;
import com.example.restapijwtsecurity.controller.auth.dto.RegisterResponse;
import com.example.restapijwtsecurity.controller.auth.dto.RegisterRequest;
import com.example.restapijwtsecurity.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
     return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
}
