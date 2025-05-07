package com.example.chatapp.controller;

import com.example.chatapp.entity.GroupChat;
import com.example.chatapp.service.GroupChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group-chats")
public class GroupChatController {

    @Autowired
    private GroupChatService groupChatService;

    @PostMapping
    public GroupChat createGroup(@RequestBody GroupChat groupChat) {
        return groupChatService.saveGroup(groupChat);
    }

    @GetMapping
    public List<GroupChat> getAllGroups() {
        return groupChatService.getAllGroups();
    }

    @GetMapping("/{id}")
    public GroupChat getGroupById(@PathVariable Long id) {
        return groupChatService.getGroupById(id).orElse(null);
    }

    @PutMapping
    public GroupChat updateGroup(@RequestBody GroupChat groupChat) {
        return groupChatService.updateGroup(groupChat);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupChatService.deleteGroup(id);
    }
    @PostMapping("/create")
    public ResponseEntity<GroupChat> createGroup(@RequestParam String groupName, @RequestBody List<Long> userIds) {
        return ResponseEntity.ok(groupChatService.createGroup(groupName, userIds));
    }

}

/*package com.example.chatapp.controller;

import com.example.chatapp.entity.GroupChat;
import com.example.chatapp.entity.User;
import com.example.chatapp.service.GroupChatService;
import com.example.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group-chats")
public class GroupChatController {

    private final GroupChatService groupChatService;
    private final UserService userService;

    @Autowired
    public GroupChatController(GroupChatService groupChatService, UserService userService) {
        this.groupChatService = groupChatService;
        this.userService = userService;
    }

    @PostMapping
    public GroupChat createGroup(@RequestBody GroupChat groupChat) {
        return groupChatService.createGroup(groupChat);
    }

    @GetMapping
    public List<GroupChat> getAllGroups() {
        return groupChatService.getAllGroups();
    }

    @GetMapping("/{id}")
    public GroupChat getGroupById(@PathVariable Long id) {
        return groupChatService.getGroupById(id);
    }

    @GetMapping("/creator/{userId}")
    public List<GroupChat> getGroupsByCreator(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return groupChatService.getGroupsByCreator(user);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupChatService.deleteGroup(id);
    }
}
*/