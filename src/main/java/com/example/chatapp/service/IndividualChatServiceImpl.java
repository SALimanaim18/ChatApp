package com.example.chatapp.service;

import com.example.chatapp.dao.IndividualChatRepository;
import com.example.chatapp.entity.IndividualChat;
import com.example.chatapp.service.IndividualChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndividualChatServiceImpl implements IndividualChatService {

    @Autowired
    private IndividualChatRepository individualChatRepository;

    @Override
    public IndividualChat saveChat(IndividualChat chat) {
        return individualChatRepository.save(chat);
    }

    @Override
    public List<IndividualChat> getAllChats() {
        return individualChatRepository.findAll();
    }

    @Override
    public Optional<IndividualChat> getChatById(Long id) {
        return individualChatRepository.findById(id);
    }

    @Override
    public IndividualChat updateChat(IndividualChat chat) {
        return individualChatRepository.save(chat);
    }

    @Override
    public void deleteChat(Long id) {
        individualChatRepository.deleteById(id);
    }
}

/*package com.example.chatapp.service;

import com.example.chatapp.entity.IndividualChat;
import com.example.chatapp.entity.User;
import com.example.chatapp.dao.IndividualChatRepository;
import com.example.chatapp.service.IndividualChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualChatServiceImpl implements IndividualChatService {

    private final IndividualChatRepository chatRepository;

    @Autowired
    public IndividualChatServiceImpl(IndividualChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public IndividualChat sendMessage(IndividualChat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public List<IndividualChat> getChatsBetweenUsers(User sender, User receiver) {
        return chatRepository.findBySenderAndReceiver(sender, receiver);
    }

    @Override
    public List<IndividualChat> getChatsBySender(User sender) {
        return chatRepository.findBySender(sender);
    }

    @Override
    public List<IndividualChat> getChatsByReceiver(User receiver) {
        return chatRepository.findByReceiver(receiver);
    }

    @Override
    public IndividualChat getChatById(Long id) {
        return chatRepository.findById(id).orElseThrow(() -> new RuntimeException("Chat not found"));
    }

    @Override
    public void deleteChat(Long id) {
        chatRepository.deleteById(id);
    }
}
*/