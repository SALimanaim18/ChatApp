package com.example.chatapp.controller;

import com.example.chatapp.entity.Settings;
import com.example.chatapp.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    @Autowired
    private SettingsService settingsService;

    @PostMapping
    public Settings createSettings(@RequestBody Settings settings) {
        return settingsService.save(settings);
    }

    @GetMapping("/{id}")
    public Optional<Settings> getSettings(@PathVariable Long id) {
        return settingsService.findById(id);
    }

    @GetMapping
    public List<Settings> getAllSettings() {
        return settingsService.findAll();
    }

    @PutMapping("/{id}")
    public Settings updateSettings(@PathVariable Long id, @RequestBody Settings settings) {
        settings.setId(id);
        return settingsService.save(settings);
    }

    @DeleteMapping("/{id}")
    public void deleteSettings(@PathVariable Long id) {
        settingsService.deleteById(id);
    }
    @PutMapping("/update")
    public ResponseEntity<Settings> updateProfile(@RequestParam Long userId, @RequestBody Settings settings) {
        return ResponseEntity.ok(settingsService.updateProfile(userId, settings));
    }

}

/*package com.example.chatapp.controller;

import com.example.chatapp.entity.Settings;
import com.example.chatapp.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    private final SettingsService settingsService;

    @Autowired
    public SettingsController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @PostMapping
    public Settings createSettings(@RequestBody Settings settings) {
        return settingsService.saveSettings(settings);
    }

    @GetMapping("/{id}")
    public Settings getSettingsById(@PathVariable Long id) {
        return settingsService.getSettingsById(id);
    }

    @GetMapping
    public List<Settings> getAllSettings() {
        return settingsService.getAllSettings();
    }

    @DeleteMapping("/{id}")
    public void deleteSettings(@PathVariable Long id) {
        settingsService.deleteSettings(id);
    }
}
*/