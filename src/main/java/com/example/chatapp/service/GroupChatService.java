package com.example.chatapp.service;

import com.example.chatapp.entity.GroupChat;

import java.util.List;
import java.util.Optional;

public interface GroupChatService {
    GroupChat saveGroup(GroupChat groupChat);
    List<GroupChat> getAllGroups();
    Optional<GroupChat> getGroupById(Long id);
    GroupChat updateGroup(GroupChat groupChat);
    void deleteGroup(Long id);
    GroupChat createGroup(String groupName, List<Long> userIds);

}

/*package com.example.chatapp.service;

import com.example.chatapp.entity.GroupChat;
import com.example.chatapp.entity.User;

import java.util.List;

public interface GroupChatService {
    GroupChat createGroup(GroupChat groupChat);
    List<GroupChat> getAllGroups();
    GroupChat getGroupById(Long id);
    List<GroupChat> getGroupsByCreator(User user);
    void deleteGroup(Long id);
}*/
