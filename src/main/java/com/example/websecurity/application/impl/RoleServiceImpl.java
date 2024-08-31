/*
package com.example.websecurity.application.impl;

import com.example.websecurity.application.service.RoleService;
import com.example.websecurity.domain.model.Role;
import com.example.websecurity.domain.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Optional<Role> findByRolename(String rolename) {
        if (rolename == null || rolename.isEmpty()) {
            throw new RuntimeException("Role not found");
        }
        return roleRepository.findByRoleName(rolename);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
*/