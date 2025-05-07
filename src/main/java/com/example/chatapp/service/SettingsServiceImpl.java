package com.example.chatapp.service;

import com.example.chatapp.dao.SettingsRepository;
import com.example.chatapp.dao.UserRepository;
import com.example.chatapp.entity.Settings;
import com.example.chatapp.entity.User;
import com.example.chatapp.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettingsServiceImpl implements SettingsService {

    @Autowired
    private SettingsRepository settingsRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Settings save(Settings settings) {
        return settingsRepository.save(settings);
    }

    @Override
    public Optional<Settings> findById(Long id) {
        return settingsRepository.findById(id);
    }

    @Override
    public List<Settings> findAll() {
        return settingsRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        settingsRepository.deleteById(id);
    }
    @Override
    public Settings updateProfile(Long userId, Settings newSettings) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setSettings(newSettings);
        return settingsRepository.save(newSettings);
    }

}

/*package com.example.chatapp.service;

import com.example.chatapp.entity.Settings;
import com.example.chatapp.dao.SettingsRepository;
import com.example.chatapp.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingsServiceImpl implements SettingsService {

    private final SettingsRepository settingsRepository;

    @Autowired
    public SettingsServiceImpl(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    @Override
    public Settings saveSettings(Settings settings) {
        return settingsRepository.save(settings);
    }

    @Override
    public Settings getSettingsById(Long id) {
        return settingsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Settings not found with ID: " + id));
    }

    @Override
    public List<Settings> getAllSettings() {
        return settingsRepository.findAll();
    }

    @Override
    public void deleteSettings(Long id) {
        settingsRepository.deleteById(id);
    }
}*/
