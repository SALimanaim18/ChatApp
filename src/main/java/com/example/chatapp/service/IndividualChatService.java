package com.example.chatapp.service;

import com.example.chatapp.entity.IndividualChat;

import java.util.List;
import java.util.Optional;

public interface IndividualChatService {
    IndividualChat saveChat(IndividualChat chat);
    List<IndividualChat> getAllChats();
    Optional<IndividualChat> getChatById(Long id);
    IndividualChat updateChat(IndividualChat chat);
    void deleteChat(Long id);

}

/*package com.example.chatapp.service;

import com.example.chatapp.entity.IndividualChat;
import com.example.chatapp.entity.User;

import java.util.List;

public interface IndividualChatService {
    IndividualChat sendMessage(IndividualChat chat);
    List<IndividualChat> getChatsBetweenUsers(User sender, User receiver);
    List<IndividualChat> getChatsBySender(User sender);
    List<IndividualChat> getChatsByReceiver(User receiver);
    IndividualChat getChatById(Long id);
    void deleteChat(Long id);
}
*/