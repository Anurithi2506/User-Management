package com.examly.springapp.controller;

import com.examly.springapp.model.Role;
import com.examly.springapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService service;

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody(required = false) Role role) {
        if (role == null || role.getRoleName() == null) {
            return ResponseEntity.badRequest().build();
        }
        Role saved = service.saveRole(role);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return service.getAllRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Role role = service.getRoleById(id);
        if (role == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(role);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role) {
        Role updated = service.updateRole(id, role);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        service.deleteRole(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page/{page}/{size}")
    public Page<Role> getRolesWithPagination(@PathVariable int page, @PathVariable int size) {
        return service.getRolesWithPagination(page, size);
    }
}
