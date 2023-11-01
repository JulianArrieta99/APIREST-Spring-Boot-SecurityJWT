package com.example.restapijwtsecurity.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExampleDto {

    @NotNull
    private String a;
    @NotNull
    private String b;
    @NotNull
    private String c;

}
