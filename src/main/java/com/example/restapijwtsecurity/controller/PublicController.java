package com.example.restapijwtsecurity.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/public")
@Tag(name = "1-Public")
@Order(1)
public class PublicController {

    @GetMapping
    @Operation(description = "Endpoint publico, puede acceder usuario con cualquier rol: (USER - MANAGER - ADMIN)")
    public String publicEndpoint(){
        return "Saludos desde el endpoint publico";
    }
}
