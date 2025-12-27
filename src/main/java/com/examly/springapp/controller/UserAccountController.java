package com.examly.springapp.controller;

import com.examly.springapp.model.UserAccount;
import com.examly.springapp.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    @Autowired
    private UserAccountService service;

    @PostMapping
    public ResponseEntity<UserAccount> createUserAccount(@RequestBody UserAccount userAccount) {
        UserAccount saved = service.saveUserAccount(userAccount);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<UserAccount> getAllUserAccounts() {
        return service.getAllUserAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUserAccountById(@PathVariable Long id) {
        UserAccount userAccount = service.getUserAccountById(id);
        if (userAccount == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAccount> updateUserAccount(@PathVariable Long id, @RequestBody UserAccount userAccount) {
        UserAccount updated = service.updateUserAccount(id, userAccount);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserAccount(@PathVariable Long id) {
        service.deleteUserAccount(id);
        return ResponseEntity.noContent().build();
    }
}
