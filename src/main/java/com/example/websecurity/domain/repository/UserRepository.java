package com.example.websecurity.domain.repository;

import com.example.websecurity.domain.model.MyUser;

import java.util.Optional;

public interface UserRepository {
    Optional<MyUser> findByUsername(String username);
    MyUser save(MyUser user);
}
