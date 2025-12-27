package com.examly.springapp.service;

import com.examly.springapp.model.Role;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RoleService {
    Role saveRole(Role role);
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
    Page<Role> getRolesWithPagination(int page, int size);
}
