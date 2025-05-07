package com.example.chatapp.service;

import com.example.chatapp.dao.ChatHistoryRepository;
import com.example.chatapp.entity.ChatHistory;
import com.example.chatapp.service.ChatHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatHistoryServiceImpl implements ChatHistoryService {

    @Autowired
    private ChatHistoryRepository chatHistoryRepository;

    @Override
    public ChatHistory saveChatHistory(ChatHistory chatHistory) {
        return chatHistoryRepository.save(chatHistory);
    }

    @Override
    public List<ChatHistory> getAllChatHistories() {
        return chatHistoryRepository.findAll();
    }

    @Override
    public ChatHistory getChatHistoryById(Long id) {
        return chatHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public ChatHistory updateChatHistory(Long id, ChatHistory updatedChatHistory) {
        Optional<ChatHistory> optional = chatHistoryRepository.findById(id);
        if (optional.isPresent()) {
            ChatHistory existing = optional.get();
            existing.setUserId(updatedChatHistory.getUserId());
            existing.setMessage(updatedChatHistory.getMessage());
            existing.setTimestamp(updatedChatHistory.getTimestamp());
            return chatHistoryRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteChatHistory(Long id) {
        chatHistoryRepository.deleteById(id);
    }
}

/*package com.example.chatapp.service;

import com.example.chatapp.entity.ChatHistory;
import com.example.chatapp.entity.User;
import com.example.chatapp.dao.ChatHistoryRepository;
import com.example.chatapp.service.ChatHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatHistoryServiceImpl implements ChatHistoryService {

    private final ChatHistoryRepository chatHistoryRepository;

    @Autowired
    public ChatHistoryServiceImpl(ChatHistoryRepository chatHistoryRepository) {
        this.chatHistoryRepository = chatHistoryRepository;
    }

    @Override
    public ChatHistory saveChatHistory(ChatHistory chatHistory) {
        return chatHistoryRepository.save(chatHistory);
    }

    @Override
    public List<ChatHistory> getAllHistory() {
        return chatHistoryRepository.findAll();
    }

    @Override
    public List<ChatHistory> getHistoryByUser(User user) {
        return chatHistoryRepository.findByUser(user);
    }

    @Override
    public ChatHistory getChatHistoryById(Long id) {
        return chatHistoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Chat history not found"));
    }

    @Override
    public void deleteChatHistory(Long id) {
        chatHistoryRepository.deleteById(id);
    }
}
*/