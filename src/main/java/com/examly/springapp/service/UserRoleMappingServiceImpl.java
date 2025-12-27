package com.examly.springapp.service;

import com.examly.springapp.model.UserRoleMapping;
import com.examly.springapp.repository.UserRoleMappingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleMappingServiceImpl implements UserRoleMappingService {
    
    @Autowired
    private UserRoleMappingRepo repo;
    
    @Override
    public UserRoleMapping saveUserRoleMapping(UserRoleMapping userRoleMapping) {
        return repo.save(userRoleMapping);
    }
    
    @Override
    public List<UserRoleMapping> getAllUserRoleMappings() {
        return repo.findAll();
    }
    
    @Override
    public UserRoleMapping getUserRoleMappingById(Long id) {
        return repo.findById(id).orElse(null);
    }
    
    @Override
    public UserRoleMapping updateUserRoleMapping(Long id, UserRoleMapping userRoleMapping) {
        userRoleMapping.setId(id);
        return repo.save(userRoleMapping);
    }
    
    @Override
    public void deleteUserRoleMapping(Long id) {
        repo.deleteById(id);
    }
    
    @Override
    public List<UserRoleMapping> getUserRoleMappingsByUserId(Long userId) {
        return repo.findByUserId(userId);
    }
    
    @Override
    public UserRoleMapping getUserRoleMappingByUserIdAndRoleId(Long userId, Long roleId) {
        return repo.findByUserIdAndRoleId(userId, roleId).orElse(null);
    }
}
