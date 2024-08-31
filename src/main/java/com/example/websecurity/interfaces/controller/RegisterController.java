package com.example.websecurity.interfaces.controller;

import com.example.websecurity.domain.model.MyUser;
import com.example.websecurity.domain.repository.RoleRepository;
import com.example.websecurity.application.service.UserService;
import com.example.websecurity.interfaces.dto.UserRegistrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;
    private final RoleRepository roleRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "register"; // Nombre del archivo HTML para el formulario de registro
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userRegistrationDtop") UserRegistrationDto userRegistrationDto, Model model) {
        try {
            userService.registerUser(userRegistrationDto); // Asigna el rol predeterminado en el servicio
            return "redirect:/login";
        } catch (Exception ex) {
            model.addAttribute("error", "Error al registrar el usuario: " + ex.getMessage());
            return "register";
        }
    }

}
