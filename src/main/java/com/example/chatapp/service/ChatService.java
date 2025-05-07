package com.example.chatapp.service;

import com.example.chatapp.entity.Chat;

import java.util.List;

public interface ChatService {
    Chat saveChat(Chat chat);
    Chat getChatById(Long id);
    List<Chat> getAllChats();
    Chat updateChat(Long id, Chat chat);
    void deleteChat(Long id);
}


/*package com.example.chatapp.service;

import com.example.chatapp.entity.Chat;
import com.example.chatapp.entity.User;

import java.util.List;

public interface ChatService {
    Chat saveChat(Chat chat);
    List<Chat> getChatsBetweenUsers(User sender, User receiver);
    List<Chat> getAllChats();
}*/
