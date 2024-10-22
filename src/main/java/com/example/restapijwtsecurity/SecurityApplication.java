package com.example.restapijwtsecurity;

import com.example.restapijwtsecurity.auth.AuthenticationService;
import com.example.restapijwtsecurity.auth.RegisterRequest;
import com.example.restapijwtsecurity.models.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

}
