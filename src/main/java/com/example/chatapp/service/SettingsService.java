package com.example.chatapp.service;

import com.example.chatapp.entity.Settings;

import java.util.List;
import java.util.Optional;

public interface SettingsService {
    Settings save(Settings settings);
    Optional<Settings> findById(Long id);
    List<Settings> findAll();
    void deleteById(Long id);
    Settings updateProfile(Long userId, Settings newSettings);

}

/*package com.example.chatapp.service;

import com.example.chatapp.entity.Settings;

import java.util.List;

public interface SettingsService {
    Settings saveSettings(Settings settings);
    Settings getSettingsById(Long id);
    List<Settings> getAllSettings();
    void deleteSettings(Long id);
}
*/