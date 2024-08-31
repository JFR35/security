package com.example.websecurity.domain.repository;

import com.example.websecurity.domain.model.Role;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByRoleName(String rolename);
    Role save(Role role);
}
