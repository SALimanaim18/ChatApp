package com.example.chatapp.entity;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class IndividualChat {

    @Id
    private String peerId;

    private String peerName;
    private String email;
    private String status;
}