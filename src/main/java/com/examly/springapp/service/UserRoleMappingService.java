package com.examly.springapp.service;

import com.examly.springapp.model.UserRoleMapping;

import java.util.List;

public interface UserRoleMappingService {
    UserRoleMapping saveUserRoleMapping(UserRoleMapping userRoleMapping);
    List<UserRoleMapping> getAllUserRoleMappings();
    UserRoleMapping getUserRoleMappingById(Long id);
    UserRoleMapping updateUserRoleMapping(Long id, UserRoleMapping userRoleMapping);
    void deleteUserRoleMapping(Long id);
    List<UserRoleMapping> getUserRoleMappingsByUserId(Long userId);
    UserRoleMapping getUserRoleMappingByUserIdAndRoleId(Long userId, Long roleId);
}
