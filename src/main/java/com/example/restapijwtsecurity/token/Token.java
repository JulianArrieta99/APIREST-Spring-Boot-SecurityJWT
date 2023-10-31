package com.example.restapijwtsecurity.token;

import com.example.restapijwtsecurity.models.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "token")
@NoArgsConstructor @AllArgsConstructor @Builder
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String token;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType;

    private boolean expired;

    private boolean revoke;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}