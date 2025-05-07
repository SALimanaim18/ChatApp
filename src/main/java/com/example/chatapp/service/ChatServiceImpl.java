package com.example.chatapp.service;

import com.example.chatapp.dao.ChatRepository;
import com.example.chatapp.entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Chat saveChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public Chat getChatById(Long id) {
        return chatRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    @Override
    public Chat updateChat(Long id, Chat chat) {
        Chat existing = chatRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setChatId(chat.getChatId());
            existing.setStatus(chat.getStatus());
            existing.setCreationDate(chat.getCreationDate());
            return chatRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteChat(Long id) {
        chatRepository.deleteById(id);
    }
}

/*package com.example.chatapp.service;

import com.example.chatapp.entity.Chat;
import com.example.chatapp.entity.User;
import com.example.chatapp.dao.ChatRepository;
import com.example.chatapp.service.ChatService;
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
    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }
}
*/