package com.example.chatapp.controller;

import com.example.chatapp.entity.ChatHistory;
import com.example.chatapp.service.ChatHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chathistory")
public class ChatHistoryController {

    @Autowired
    private ChatHistoryService chatHistoryService;

    @PostMapping
    public ChatHistory createChatHistory(@RequestBody ChatHistory chatHistory) {
        return chatHistoryService.saveChatHistory(chatHistory);
    }

    @GetMapping
    public List<ChatHistory> getAllChatHistories() {
        return chatHistoryService.getAllChatHistories();
    }

    @GetMapping("/{id}")
    public ChatHistory getChatHistoryById(@PathVariable Long id) {
        return chatHistoryService.getChatHistoryById(id);
    }

    @PutMapping("/{id}")
    public ChatHistory updateChatHistory(@PathVariable Long id, @RequestBody ChatHistory chatHistory) {
        return chatHistoryService.updateChatHistory(id, chatHistory);
    }

    @DeleteMapping("/{id}")
    public void deleteChatHistory(@PathVariable Long id) {
        chatHistoryService.deleteChatHistory(id);
    }
}

/*package com.example.chatapp.controller;

import com.example.chatapp.entity.ChatHistory;
import com.example.chatapp.entity.User;
import com.example.chatapp.service.ChatHistoryService;
import com.example.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat-history")
public class ChatHistoryController {

    private final ChatHistoryService chatHistoryService;
    private final UserService userService;

    @Autowired
    public ChatHistoryController(ChatHistoryService chatHistoryService, UserService userService) {
        this.chatHistoryService = chatHistoryService;
        this.userService = userService;
    }

    @PostMapping
    public ChatHistory saveChatHistory(@RequestBody ChatHistory chatHistory) {
        return chatHistoryService.saveChatHistory(chatHistory);
    }

    @GetMapping
    public List<ChatHistory> getAllChatHistory() {
        return chatHistoryService.getAllHistory();
    }

    @GetMapping("/{id}")
    public ChatHistory getChatHistoryById(@PathVariable Long id) {
        return chatHistoryService.getChatHistoryById(id);
    }

    @GetMapping("/user/{userId}")
    public List<ChatHistory> getChatHistoryByUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return chatHistoryService.getHistoryByUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteChatHistory(@PathVariable Long id) {
        chatHistoryService.deleteChatHistory(id);
    }
}
*/