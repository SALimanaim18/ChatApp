package com.example.chatapp.service;

import com.example.chatapp.entity.Message;

import java.util.List;

public interface MessageService {
    Message saveMessage(Message message);
    Message getMessageById(Long id);
    List<Message> getAllMessages();
    void deleteMessage(Long id);
    Message updateMessage(Long id, Message message);
}

/*package com.example.chatapp.service;

import com.example.chatapp.entity.Message;

import java.util.List;

public interface MessageService {
    Message saveMessage(Message message);
    Message getMessageById(Long id);
    List<Message> getAllMessages();
    List<Message> getMessagesByType(int type);
    void deleteMessage(Long id);
}*/
