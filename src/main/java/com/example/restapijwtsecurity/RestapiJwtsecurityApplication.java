package com.example.restapijwtsecurity;

import com.example.restapijwtsecurity.auth.AuthenticationService;
import com.example.restapijwtsecurity.auth.RegisterRequest;
import com.example.restapijwtsecurity.models.Role;
import com.example.restapijwtsecurity.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestapiJwtsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapiJwtsecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ){
        return args ->{
            var admin = RegisterRequest.builder()
                    .firstname("Admin")
                    .lastname("adminn")
                    .email("admin@mail.com")
                    .password("password")
                    .role(Role.ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .firstname("manager")
                    .lastname("manager")
                    .email("manager@mail.com")
                    .password("password")
                    .role(Role.MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());
        };
    }
}
