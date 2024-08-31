package com.example.websecurity.interfaces.api;

import com.example.websecurity.application.service.UserService;
import com.example.websecurity.domain.model.MyUser;
import com.example.websecurity.interfaces.dto.UserLoginDto;
import com.example.websecurity.interfaces.dto.UserRegistrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        try {
            userService.registerUser(registrationDto);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error registering user: " + ex.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDto loginDto) {
        try {
            MyUser user = userService.loginUser(loginDto);
            // Generate JWT token here
            String token = "dummy-token"; // Replace with actual JWT token generation, de momento no hay tokens
            return ResponseEntity.ok(token);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }
}