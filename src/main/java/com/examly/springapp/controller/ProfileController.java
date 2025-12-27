package com.examly.springapp.controller;

import com.examly.springapp.model.Profile;
import com.examly.springapp.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService service;

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        Profile saved = service.saveProfile(profile);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public List<Profile> getAllProfiles() {
        return service.getAllProfiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        Profile profile = service.getProfileById(id);
        if (profile == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        Profile updated = service.updateProfile(id, profile);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        service.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/name/{firstName}")
    public ResponseEntity<List<Profile>> getProfilesByName(@PathVariable String firstName) {
        List<Profile> profiles = service.getProfilesByName(firstName);
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/search/{firstName}/{address}")
    public ResponseEntity<List<Profile>> getProfilesByNameAndAddress(@PathVariable String firstName, @PathVariable String address) {
        List<Profile> profiles = service.getProfilesByNameAndAddress(firstName, address);
        return ResponseEntity.ok(profiles);
    }
}
