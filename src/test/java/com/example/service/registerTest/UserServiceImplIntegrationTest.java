package com.example.service.registerTest;


import com.example.websecurity.domain.model.MyUser;
import com.example.websecurity.domain.repository.UserRepository;
import com.example.websecurity.application.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceImplIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    // Integration test to register new user successfusly
    @Test
    @Transactional
    public void register_newUser_successfusly_test() throws Exception {
        // Arrange
        MyUser user = new MyUser();
        user.setUsername("Juanito");
        user.setPassword("1234"); // Contraseña que será encriptada

        // Act
        userService.registerUser(user);

        // Assert
        Optional<MyUser> savedUserOptional = userRepository.findByUsername("Juanito");
        assertThat(savedUserOptional).isPresent(); // Verifica que el usuario está presente
        MyUser savedUser = savedUserOptional.get(); // Desempaqueta el Optional
        assertThat(savedUser.getUsername()).isEqualTo("Juanito");
        assertThat(savedUser.getPassword()).isNotEqualTo("1234"); // Verifica que la contraseña está encriptada
    }

    // Try to insert a new user with the same name
    @Test
    @Transactional
    public void register_user_with_duplicate_username_test() {
        // New user1
        MyUser user1 = new MyUser();
        user1.setUsername("Jose");
        user1.setPassword("1234");
        // New user2 with the same name
        MyUser user2 = new MyUser();
        user2.setPassword("Jose");
        user2.setPassword("1234");
        assertThrows(DataIntegrityViolationException.class, () -> {
            userService.registerUser(user2);
        });

    }

    // Register new user with emtpy field
    @Test
    @Transactional
    public void register_user_with_invalid_data() {
        MyUser user = new MyUser();
        user.setUsername(""); // Username is Empty
        user.setPassword("1234");
        assertThrows(Exception.class, () -> {
            userService.registerUser(user);
        });
    }
}


