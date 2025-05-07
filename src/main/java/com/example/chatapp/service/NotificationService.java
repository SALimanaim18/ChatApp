package com.example.chatapp.service;

import com.example.chatapp.entity.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    Notification saveNotification(Notification notification);
    Optional<Notification> getNotificationById(Long id);
    List<Notification> getAllNotifications();
    void deleteNotification(Long id);
    List<Notification> getUserNotifications(Long userId);

}
