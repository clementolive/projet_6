package com.openclassrooms.mddapi.models.requests;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class LoginRequest {
    @NotBlank
    String email;
    @NotBlank
    String password;
}
