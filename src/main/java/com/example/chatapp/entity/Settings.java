package com.example.chatapp.entity;

import com.example.chatapp.enums.PrivacyLevel;
import jakarta.persistence.*;

@Entity
@Table(name = "settings")
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean notificationEnabled;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PrivacyLevel privacyLevel;

    public Settings() {}

    public Settings(boolean notificationEnabled, PrivacyLevel privacyLevel) {
        this.notificationEnabled = notificationEnabled;
        this.privacyLevel = privacyLevel;
    }

    public Long getId() { return id; }
    public boolean isNotificationEnabled() { return notificationEnabled; }
    public PrivacyLevel getPrivacyLevel() { return privacyLevel; }
    public void setId(Long id) { this.id = id; }
    public void setNotificationEnabled(boolean notificationEnabled) { this.notificationEnabled = notificationEnabled; }
    public void setPrivacyLevel(PrivacyLevel privacyLevel) { this.privacyLevel = privacyLevel; }
}

/*package com.example.chatapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "settings")
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String theme;

    @Column(nullable = false)
    private Boolean notificationsEnabled;

    @Column(nullable = false)
    private String language;

    public Settings() {
    }

    public Settings(String theme, Boolean notificationsEnabled, String language) {
        this.theme = theme;
        this.notificationsEnabled = notificationsEnabled;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Boolean getNotificationsEnabled() {
        return notificationsEnabled;
    }

    public void setNotificationsEnabled(Boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
*/