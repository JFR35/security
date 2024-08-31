package com.example.websecurity.user.controller;

import com.example.websecurity.user.model.entity.MyUser;
import com.example.websecurity.user.model.repository.RoleRepository;
import com.example.websecurity.user.model.service.UserService;
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
        model.addAttribute("user", new MyUser());
        return "register"; // Nombre del archivo HTML para el formulario de registro
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") MyUser user, Model model) {
        try {
            userService.registerUser(user); // Asigna el rol predeterminado en el servicio
            return "redirect:/login";
        } catch (Exception ex) {
            model.addAttribute("error", "Error al registrar el usuario: " + ex.getMessage());
            return "register";
        }
    }

}
