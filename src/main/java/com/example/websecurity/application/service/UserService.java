package com.example.websecurity.application.service;

import com.example.websecurity.domain.model.entity.MyUser;

public interface UserService {
    void registerUser(MyUser user) throws Exception;

    MyUser loginUser(String username, String rawPassword) throws Exception;
}
