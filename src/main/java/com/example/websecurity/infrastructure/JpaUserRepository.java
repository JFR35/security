package com.example.websecurity.infrastructure;

import com.example.websecurity.domain.model.MyUser;
import com.example.websecurity.domain.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends UserRepository, JpaRepository<MyUser, Long> {
    //Optional<MyUser> findByUsername(String username);

}
