package com.example.chatapp.service;

import com.example.chatapp.entity.ChatHistory;

import java.util.List;

public interface ChatHistoryService {
    ChatHistory saveChatHistory(ChatHistory chatHistory);
    List<ChatHistory> getAllChatHistories();
    ChatHistory getChatHistoryById(Long id);
    ChatHistory updateChatHistory(Long id, ChatHistory updatedChatHistory);
    void deleteChatHistory(Long id);
}

/*package com.example.chatapp.service;

import com.example.chatapp.entity.ChatHistory;
import com.example.chatapp.entity.User;

import java.util.List;

public interface ChatHistoryService {
    ChatHistory saveChatHistory(ChatHistory chatHistory);
    List<ChatHistory> getAllHistory();
    List<ChatHistory> getHistoryByUser(User user);
    ChatHistory getChatHistoryById(Long id);
    void deleteChatHistory(Long id);
}
*/