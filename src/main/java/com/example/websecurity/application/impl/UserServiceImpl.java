package com.example.websecurity.application.service;

import com.example.websecurity.domain.model.entity.MyUser;
import com.example.websecurity.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(MyUser user) throws Exception {
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new Exception("Username cannot be empty");
        }
        // Asegúrate de que la contraseña esté encriptada
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Guarda el usuario en la base de datos
        MyUser savedUser = userRepository.save(user);
        System.out.println("User saved: " + savedUser); // Depuración

    }

    public MyUser loginUser(String username, String rawPassword) throws Exception {
        MyUser user = userRepository.findByUsername(username)
                .<Exception>orElseThrow(() -> new Exception("User notr found"));

        if (passwordEncoder.matches(rawPassword, user.getPassword())) {
            // Aqui se podria generar el token
            return user;

        } else {
            throw new Exception("Invalid credentials");
        }
    }
}
