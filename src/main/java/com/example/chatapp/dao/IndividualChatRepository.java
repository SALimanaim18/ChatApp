package com.example.chatapp.dao;

import com.example.chatapp.entity.IndividualChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualChatRepository extends JpaRepository<IndividualChat, Long> {
}

/*package com.example.chatapp.dao;

import com.example.chatapp.entity.IndividualChat;
import com.example.chatapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndividualChatRepository extends JpaRepository<IndividualChat, Long> {
    List<IndividualChat> findBySender(User sender);
    List<IndividualChat> findByReceiver(User receiver);
    List<IndividualChat> findBySenderAndReceiver(User sender, User receiver);
}
*/