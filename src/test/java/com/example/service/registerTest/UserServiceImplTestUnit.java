package com.example.service.registerTest;

import com.example.user.MyUser;
import com.example.user.UserRepository;
import com.example.user.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceImplTestUnit {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterUser() throws Exception {
        // Arrange
        MyUser user = new MyUser();
        user.setUsername("testuser");
        user.setPassword("password");

        // Mock the password encoder to return a specific encoded value
        when(passwordEncoder.encode(any(String.class))).thenReturn("encodedPassword");

        // Act
        userService.registerUser(user);

        // Assert
        verify(passwordEncoder).encode("password"); // Verify encode was called with "password"
        verify(userRepository).save(user); // Verify save was called with user
    }

    @Test
    void testPasswordEncoding() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "1234";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        assertNotEquals(rawPassword, encodedPassword);
        assertTrue(passwordEncoder.matches(rawPassword, encodedPassword));
    }
    @Test
    void testRegisterUserService() throws Exception {
        MyUser user = new MyUser();
        user.setUsername("Juan");
        user.setPassword("1234");

        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(MyUser.class))).thenReturn(user);

        userService.registerUser(user);

        verify(passwordEncoder).encode("1234");
        verify(userRepository).save(user);
    }
}
