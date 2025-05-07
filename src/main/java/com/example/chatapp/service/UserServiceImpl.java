package com.example.chatapp.service;

import com.example.chatapp.dao.UserRepository;
import com.example.chatapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        return userRepository.findById(id).map(u -> {
            u.setUsername(user.getUsername());
            u.setPassword(user.getPassword());
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setBirthDate(user.getBirthDate());
            u.setProfileName(user.getProfileName());
            u.setEmail(user.getEmail());
            u.setStatus(user.getStatus());
            u.setPhoneNumber(user.getPhoneNumber());
            u.setAge(user.getAge());
            u.setSettings(user.getSettings());
            return userRepository.save(u);
        }).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void blockUser(Long userId, Long blockedUserId) {
        User user = getUserById(userId);
        User toBlock = getUserById(blockedUserId);
        if (user != null && toBlock != null) {
            user.getBlockedUsers().add(toBlock);
            userRepository.save(user);
        }
    }

    @Override
    public void sendInvitation(Long senderId, Long receiverId) {
        User sender = getUserById(senderId);
        User receiver = getUserById(receiverId);
        if (sender != null && receiver != null) {
            sender.getInvitationsSent().add(receiver);
            userRepository.save(sender);
        }
    }

    @Override
    public void acceptInvitation(Long receiverId, Long senderId) {
        User receiver = getUserById(receiverId);
        User sender = getUserById(senderId);
        if (receiver != null && sender != null && sender.getInvitationsSent().contains(receiver)) {
            sender.getInvitationsSent().remove(receiver);
            // Optionnel : créer relation de contact ici
            userRepository.save(sender);
        }
    }

    @Override
    public List<User> searchUsers(String query) {
        return userRepository.findByUsernameContainingIgnoreCase(query);
    }
}


/*package com.example.chatapp.service;

import com.example.chatapp.entity.User;
import com.example.chatapp.dao.UserRepository;
import com.example.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        user.setUsername(userDetails.getUsername());
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setBirthdate(userDetails.getBirthdate());
        user.setProfileName(userDetails.getProfileName());
        user.setEmailId(userDetails.getEmailId());
        user.setStatus(userDetails.getStatus());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setAge(userDetails.getAge());
        user.setSettings(userDetails.getSettings());
        return userRepository.save(user);
    }
}*/
