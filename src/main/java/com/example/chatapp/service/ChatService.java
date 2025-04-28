package com.example.chatapp.service;


import com.example.chatapp.entity.Chat;
import com.example.chatapp.entity.User;

import java.util.List;

public interface ChatService {

    Chat saveChat(Chat chat);

    List<Chat> getChatsBetweenUsers(User sender, User receiver);

    List<Chat> getReceivedChats(User receiver);
}

