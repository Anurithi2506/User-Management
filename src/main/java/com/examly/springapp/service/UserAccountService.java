package com.examly.springapp.service;

import com.examly.springapp.model.UserAccount;

import java.util.List;

public interface UserAccountService {
    UserAccount saveUserAccount(UserAccount userAccount);
    List<UserAccount> getAllUserAccounts();
    UserAccount getUserAccountById(Long id);
    UserAccount updateUserAccount(Long id, UserAccount userAccount);
    void deleteUserAccount(Long id);
}
