package com.example.chatapp.service;

import com.example.chatapp.dao.ChatRepository;
import com.example.chatapp.entity.Chat;
import com.example.chatapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public Chat saveChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public List<Chat> getChatsBetweenUsers(User sender, User receiver) {
        return chatRepository.findBySenderAndReceiver(sender, receiver);
    }

    @Override
    public List<Chat> getReceivedChats(User receiver) {
        return chatRepository.findByReceiver(receiver);
    }
}

