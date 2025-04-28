package com.example.chatapp.entity;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class GroupChat {

    @Id
    private String groupId;

    private String groupName;
    private String msgType;
    private String attribute;
}
