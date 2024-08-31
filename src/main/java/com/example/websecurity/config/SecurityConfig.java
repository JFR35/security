package com.example.websecurity.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) // Desactiva CSRF para simplificar
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/views/**", "/home", "/login", "/register").permitAll() // Permite acceso a todas las vistas
                        .requestMatchers("/api/register", "/api/login").permitAll() // Permite acceso a los endpoints de API de register y login
                        .anyRequest().permitAll() // Permite acceso a cualquier otra solicitud
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/dashboard") // Redirige a /home después de un login exitoso
                        .failureUrl("/login?error=true") // Redirige a /login con un parámetro de error si el login falla
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL para el logout
                        .logoutSuccessUrl("/home") // Redirige a /login después de un logout exitoso
                        .permitAll()
                )
                .build();
    }
}

