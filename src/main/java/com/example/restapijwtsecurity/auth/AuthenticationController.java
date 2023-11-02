package com.example.restapijwtsecurity.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(description = "Registra un usuario y obten el jwt token + refresh token",
            responses = {@ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized / Invalid token", responseCode = "403")})
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody @Schema(example = "{\n" +
                    "  \"email\": \"example@email.com\",\n" +
                    "  \"password\": \"examplePassword\",\n" +
                    "  \"firstname\": \"exampleFirstName\",\n" +
                    "  \"lastname\": \"exampleLastName\",\n" +
                    "  \"role\": \"USER\"  // Can be 'USER', 'MANAGER', or 'ADMIN'\n" +
                    "}") RegisterRequest request
    ){
     return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    @Operation(description = "Logea un usuario para obtener jwt token + refresh token",
            responses = {@ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized / Invalid token", responseCode = "403")})
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Schema(example = "{\n" +
            "  \"username\": \"exampleUser\",\n" +
            "  \"password\": \"examplePassword\"\n" +
            "}") AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/refresh-token")
    @Operation(description = "Utiliza el refresh token generado para obtener un nuevo jwt token",
            responses = {@ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized / Invalid token", responseCode = "403")})
    public void refreshToken (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
    authenticationService.refreshToken(request, response);
    }
}
