package com.example.websecurity.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name", nullable = false, unique = true) // Unique to avoid duplicates
    private String roleName;

    @Override
    public String getAuthority() {
        return roleName; // Retrieve rolname as authority
    }
}
