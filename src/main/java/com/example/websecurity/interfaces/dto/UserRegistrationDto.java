package com.example.websecurity.interfaces.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class UserRegistrationDto {
    @NotBlank(message = "Username cannot be blank")
    @Size(min = 3, message = "Username must be at least 3 characters long")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    //private String role; // Optional field for role
}
