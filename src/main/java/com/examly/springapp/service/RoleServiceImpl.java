package com.examly.springapp.service;

import com.examly.springapp.model.Role;
import com.examly.springapp.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo repo;

    @Override
    public Role saveRole(Role role) {
        return repo.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return repo.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Role updateRole(Long id, Role role) {
        role.setId(id);
        return repo.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Page<Role> getRolesWithPagination(int page, int size) {
        return repo.findAll(PageRequest.of(page, size));
    }
}
