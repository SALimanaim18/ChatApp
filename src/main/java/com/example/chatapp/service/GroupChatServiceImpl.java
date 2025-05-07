package com.example.chatapp.service;

import com.example.chatapp.dao.GroupChatRepository;
import com.example.chatapp.dao.UserRepository;
import com.example.chatapp.entity.GroupChat;
import com.example.chatapp.entity.User;
import com.example.chatapp.service.GroupChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupChatServiceImpl implements GroupChatService {

    @Autowired
    private GroupChatRepository groupChatRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public GroupChat saveGroup(GroupChat groupChat) {
        return groupChatRepository.save(groupChat);
    }

    @Override
    public List<GroupChat> getAllGroups() {
        return groupChatRepository.findAll();
    }

    @Override
    public Optional<GroupChat> getGroupById(Long id) {
        return groupChatRepository.findById(id);
    }

    @Override
    public GroupChat updateGroup(GroupChat groupChat) {
        return groupChatRepository.save(groupChat);
    }

    @Override
    public void deleteGroup(Long id) {
        groupChatRepository.deleteById(id);
    }

    @Override
    public GroupChat createGroup(String groupName, List<Long> userIds) {
        List<User> users = userRepository.findAllById(userIds);
        GroupChat groupChat = new GroupChat();
        groupChat.setGroupName(groupName);
        groupChat.setMembers(users);
        return groupChatRepository.save(groupChat);
    }

}

/*package com.example.chatapp.service;

import com.example.chatapp.entity.GroupChat;
import com.example.chatapp.entity.User;
import com.example.chatapp.dao.GroupChatRepository;
import com.example.chatapp.service.GroupChatService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupChatServiceImpl implements GroupChatService {

    private final GroupChatRepository groupChatRepository;

    @Autowired
    public GroupChatServiceImpl(GroupChatRepository groupChatRepository) {
        this.groupChatRepository = groupChatRepository;
    }

    @Override
    public GroupChat createGroup(GroupChat groupChat) {
        return groupChatRepository.save(groupChat);
    }

    @Override
    public List<GroupChat> getAllGroups() {
        return groupChatRepository.findAll();
    }

    @Override
    public GroupChat getGroupById(Long id) {
        return groupChatRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Group not found"));
    }

    @Override
    public List<GroupChat> getGroupsByCreator(User user) {
        return groupChatRepository.findByCreatedBy(user);
    }

    @Override
    public void deleteGroup(Long id) {
        groupChatRepository.deleteById(id);
    }
}*/
