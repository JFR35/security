package com.example.controller;

import com.example.user.MyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new MyUser()); // Asegura que el modelo tiene un objeto MyUser
        return "login"; // Nombre del archivo HTML para la página de inicio de sesión
    }

}
