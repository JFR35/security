package com.example.websecurity.infrastructure;

import com.example.websecurity.domain.model.Role;
import com.example.websecurity.domain.repository.RoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaRoleRepository extends RoleRepository, JpaRepository<Role, Long> {
    //Optional<Role> findByRoleName(String rolename);
}
