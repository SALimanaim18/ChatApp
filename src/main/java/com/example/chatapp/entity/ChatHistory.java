package com.example.chatapp.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ChatHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String thread;
    private String sender;
}
