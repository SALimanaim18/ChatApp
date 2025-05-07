package com.example.chatapp.controller;

import com.example.chatapp.entity.IndividualChat;
import com.example.chatapp.service.IndividualChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/individual-chats")
public class IndividualChatController {

    @Autowired
    private IndividualChatService individualChatService;

    @PostMapping
    public IndividualChat createChat(@RequestBody IndividualChat chat) {
        return individualChatService.saveChat(chat);
    }

    @GetMapping
    public List<IndividualChat> getAllChats() {
        return individualChatService.getAllChats();
    }

    @GetMapping("/{id}")
    public IndividualChat getChatById(@PathVariable Long id) {
        return individualChatService.getChatById(id).orElse(null);
    }

    @PutMapping
    public IndividualChat updateChat(@RequestBody IndividualChat chat) {
        return individualChatService.updateChat(chat);
    }

    @DeleteMapping("/{id}")
    public void deleteChat(@PathVariable Long id) {
        individualChatService.deleteChat(id);
    }
}

/*package com.example.chatapp.controller;

import com.example.chatapp.entity.IndividualChat;
import com.example.chatapp.entity.User;
import com.example.chatapp.service.IndividualChatService;
import com.example.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/individual-chats")
public class IndividualChatController {

    private final IndividualChatService chatService;
    private final UserService userService;

    @Autowired
    public IndividualChatController(IndividualChatService chatService, UserService userService) {
        this.chatService = chatService;
        this.userService = userService;
    }

    @PostMapping
    public IndividualChat sendMessage(@RequestBody IndividualChat chat) {
        return chatService.sendMessage(chat);
    }

    @GetMapping("/conversation")
    public List<IndividualChat> getChatsBetweenUsers(@RequestParam Long senderId, @RequestParam Long receiverId) {
        User sender = userService.getUserById(senderId);
        User receiver = userService.getUserById(receiverId);
        return chatService.getChatsBetweenUsers(sender, receiver);
    }

    @GetMapping("/sender/{id}")
    public List<IndividualChat> getChatsBySender(@PathVariable Long id) {
        User sender = userService.getUserById(id);
        return chatService.getChatsBySender(sender);
    }

    @GetMapping("/receiver/{id}")
    public List<IndividualChat> getChatsByReceiver(@PathVariable Long id) {
        User receiver = userService.getUserById(id);
        return chatService.getChatsByReceiver(receiver);
    }

    @DeleteMapping("/{id}")
    public void deleteChat(@PathVariable Long id) {
        chatService.deleteChat(id);
    }
}
*/