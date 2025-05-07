package com.example.chatapp.controller;

import com.example.chatapp.entity.Chat;
import com.example.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public Chat createChat(@RequestBody Chat chat) {
        return chatService.saveChat(chat);
    }

    @GetMapping("/{id}")
    public Chat getChat(@PathVariable Long id) {
        return chatService.getChatById(id);
    }

    @GetMapping
    public List<Chat> getAllChats() {
        return chatService.getAllChats();
    }

    @PutMapping("/{id}")
    public Chat updateChat(@PathVariable Long id, @RequestBody Chat chat) {
        return chatService.updateChat(id, chat);
    }

    @DeleteMapping("/{id}")
    public void deleteChat(@PathVariable Long id) {
        chatService.deleteChat(id);
    }
}

/*package com.example.chatapp.controller;

import com.example.chatapp.entity.Chat;
import com.example.chatapp.entity.User;
import com.example.chatapp.service.ChatService;
import com.example.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    private final ChatService chatService;
    private final UserService userService;

    @Autowired
    public ChatController(ChatService chatService, UserService userService) {
        this.chatService = chatService;
        this.userService = userService;
    }

    @PostMapping
    public Chat sendMessage(@RequestBody Chat chat) {
        return chatService.saveChat(chat);
    }

    @GetMapping("/{senderId}/{receiverId}")
    public List<Chat> getChatsBetweenUsers(@PathVariable Long senderId, @PathVariable Long receiverId) {
        User sender = userService.getUserById(senderId);
        User receiver = userService.getUserById(receiverId);
        return chatService.getChatsBetweenUsers(sender, receiver);
    }

    @GetMapping
    public List<Chat> getAllChats() {
        return chatService.getAllChats();
    }
}
*/