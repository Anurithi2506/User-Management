package com.examly.springapp.controller;

import com.examly.springapp.model.AccountStatusLog;
import com.examly.springapp.service.AccountStatusLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accountStatusLogs")
public class AccountStatusLogController {

    @Autowired
    private AccountStatusLogService service;

    @PostMapping
    public ResponseEntity<AccountStatusLog> createAccountStatusLog(@RequestBody AccountStatusLog accountStatusLog) {
        AccountStatusLog saved = service.saveAccountStatusLog(accountStatusLog);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public List<AccountStatusLog> getAllAccountStatusLogs() {
        return service.getAllAccountStatusLogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountStatusLog> getAccountStatusLogById(@PathVariable Long id) {
        AccountStatusLog accountStatusLog = service.getAccountStatusLogById(id);
        if (accountStatusLog == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(accountStatusLog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountStatusLog> updateAccountStatusLog(@PathVariable Long id, @RequestBody AccountStatusLog accountStatusLog) {
        AccountStatusLog updated = service.updateAccountStatusLog(id, accountStatusLog);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountStatusLog(@PathVariable Long id) {
        service.deleteAccountStatusLog(id);
        return ResponseEntity.noContent().build();
    }
}
