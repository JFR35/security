package com.example.websecurity.domain.repository;

import com.example.websecurity.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String rolename);
}
