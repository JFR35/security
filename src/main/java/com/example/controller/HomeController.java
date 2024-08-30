package com.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class HomeController {
    @GetMapping("/home")
    public String showHomePage() {
        return "home"; // Nombre del archivo HTML para la página principal
    }

}
