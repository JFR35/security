package com.example.user;

import java.util.Set;

public interface UserService {
    void registerUser(MyUser user) throws Exception;

    MyUser loginUser(String username, String rawPassword) throws Exception;
}
