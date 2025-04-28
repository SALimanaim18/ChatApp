package com.example.chatapp.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int typeMsg;
    private int typeImage;
    private int typeVoice;
    private int typeVideo;
    private int typeLocation;
    private int typeAck;

    private String content;
    private LocalDateTime time;
}