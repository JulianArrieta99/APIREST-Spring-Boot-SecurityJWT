package com.example.restapijwtsecurity.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manager")
@Tag(name = "3-Manager")
@Order(3)
public class ManagerController {

    @Operation(description = "Get endpoint de manager (Solo se puede acceder con token de manager o admin)",
            responses = {@ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Unauthorized / Invalid token", responseCode = "403")})
    @GetMapping
    public String get(){
        return "GET:: manager controller";
    }

    @Operation(description = "Post endpoint de manager (Solo se puede acceder con token de manager o admin)",
            responses = {@ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized / Invalid token", responseCode = "403")})
    @PostMapping
    public String post(){
        return "POST:: manager controller";
    }

    @Operation(description = "Put endpoint de manager (Solo se puede acceder con token de manager o admin)",
            responses = {@ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized / Invalid token", responseCode = "403")})
    @PutMapping
    public String put(){
        return "PUT:: manager controller";
    }

    @Operation(description = "Delete endpoint de manager (Solo se puede acceder con token de manager o admin)",
            responses = {@ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized / Invalid token", responseCode = "403")})
    @DeleteMapping
    public String delete(){
        return "DELETE:: manager controller";
    }
}
