package com.examly.springapp.controller;

import com.examly.springapp.model.UserRoleMapping;
import com.examly.springapp.service.UserRoleMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userRoleMappings")
public class UserRoleMappingController {

    @Autowired
    private UserRoleMappingService service;

    @PostMapping
    public ResponseEntity<UserRoleMapping> createUserRoleMapping(@RequestBody UserRoleMapping userRoleMapping) {
        UserRoleMapping saved = service.saveUserRoleMapping(userRoleMapping);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public List<UserRoleMapping> getAllUserRoleMappings() {
        return service.getAllUserRoleMappings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRoleMapping> getUserRoleMappingById(@PathVariable Long id) {
        UserRoleMapping userRoleMapping = service.getUserRoleMappingById(id);
        if (userRoleMapping == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userRoleMapping);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRoleMapping> updateUserRoleMapping(@PathVariable Long id, @RequestBody UserRoleMapping userRoleMapping) {
        UserRoleMapping updated = service.updateUserRoleMapping(id, userRoleMapping);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserRoleMapping(@PathVariable Long id) {
        service.deleteUserRoleMapping(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserRoleMapping>> getUserRoleMappingsByUserId(@PathVariable Long userId) {
        List<UserRoleMapping> mappings = service.getUserRoleMappingsByUserId(userId);
        if (mappings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mappings);
    }

    @GetMapping("/user/{userId}/role/{roleId}")
    public ResponseEntity<UserRoleMapping> getUserRoleMappingByUserIdAndRoleId(@PathVariable Long userId, @PathVariable Long roleId) {
        UserRoleMapping mapping = service.getUserRoleMappingByUserIdAndRoleId(userId, roleId);
        if (mapping == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mapping);
    }
}
