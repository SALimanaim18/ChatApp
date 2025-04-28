package com.example.chatapp.service;


import com.example.chatapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createAccount(User user);
    Optional<User> login(String username, String password);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    void deleteUser(Long id);
    User updateUser(User user);
}

