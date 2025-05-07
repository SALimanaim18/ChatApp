package com.example.chatapp.service;

import com.example.chatapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    User findByUsername(String username);
    Optional<User> login(String username, String password);
    void blockUser(Long userId, Long blockedUserId);
    void sendInvitation(Long senderId, Long receiverId);
    void acceptInvitation(Long receiverId, Long senderId);
    List<User> searchUsers(String query);
}

/*package com.example.chatapp.service;

import com.example.chatapp.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
    User updateUser(Long id, User user);
}
*/