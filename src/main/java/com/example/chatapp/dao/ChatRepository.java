package com.example.chatapp.dao;

import com.example.chatapp.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
}


/*package com.example.chatapp.dao;

import com.example.chatapp.entity.Chat;
import com.example.chatapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findBySenderAndReceiver(User sender, User receiver);
    List<Chat> findByReceiver(User receiver);
    List<Chat> findBySender(User sender);
}*/
