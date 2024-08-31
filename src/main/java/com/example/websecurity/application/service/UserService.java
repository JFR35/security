package com.example.websecurity.application.service;

import com.example.websecurity.domain.model.MyUser;
import com.example.websecurity.interfaces.dto.UserLoginDto;
import com.example.websecurity.interfaces.dto.UserRegistrationDto;

public interface UserService {
    void registerUser(UserRegistrationDto registrationDto) throws Exception;

    MyUser loginUser(UserLoginDto loginDto) throws Exception;
}
