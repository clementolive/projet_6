package com.openclassrooms.mddapi.models.requests;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UpdateUserRequest {
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    private String username;
}
