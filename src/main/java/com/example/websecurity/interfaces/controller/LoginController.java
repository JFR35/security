package com.example.websecurity.interfaces.controller;

import com.example.websecurity.domain.model.MyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new MyUser()); // Asegura que el modelo tiene un objeto MyUser
        return "login"; // Nombre del archivo HTML para la página de inicio de sesión
    }

}
