package com.example.websecurity.application.impl;

import com.example.websecurity.application.service.UserService;
import com.example.websecurity.domain.model.MyUser;
import com.example.websecurity.domain.model.Role;
import com.example.websecurity.domain.repository.UserRepository;
import com.example.websecurity.interfaces.dto.UserLoginDto;
import com.example.websecurity.interfaces.dto.UserRegistrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    //private final RoleService roleService;


    @Override
    public void registerUser(UserRegistrationDto registrationDto) throws Exception {
        if (registrationDto.getUsername() == null || registrationDto.getUsername().isEmpty()) {
            throw new Exception("Username cannot be empty");
        }
        // Validar si el usuario ya existe
        if (userRepository.findByUsername(registrationDto.getUsername()).isPresent()) {
            throw new Exception("User already exists");
        }

        // Convertir DTO a entidad
        MyUser user = new MyUser();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        // Asignar rol al usuario
        /*Asignar rol al usuario
        String roleName = (registrationDto.getRole() != null && !registrationDto.getRole().isEmpty()) ? registrationDto.getRole() : "USER";
        Optional<Role> role = roleService.findByRolename(roleName);

        if (role.isPresent()) {
            user.setRoles(Collections.singleton(role.get()));
        } else {
            throw new Exception("Role not found");
        }
        */
        // Guarda el usuario en la base de datos
        MyUser savedUser = userRepository.save(user);
        System.out.println("User saved: " + savedUser); // Depuración

    }


    @Override
    public MyUser loginUser(UserLoginDto loginDto) throws Exception {
        MyUser user = userRepository.findByUsername(loginDto.getUsername())
                .orElseThrow(() -> new Exception("User not found"));

        if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            // Aquí podrías generar y devolver un token o cualquier otro tipo de respuesta
            return user;
        } else {
            throw new Exception("Invalid credentials");
        }
    }

}
