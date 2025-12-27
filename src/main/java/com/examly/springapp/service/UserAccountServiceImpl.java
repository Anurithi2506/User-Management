package com.examly.springapp.service;

import com.examly.springapp.model.UserAccount;
import com.examly.springapp.repository.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    
    @Autowired
    private UserAccountRepo repo;
    
    @Override
    public UserAccount saveUserAccount(UserAccount userAccount) {
        return repo.save(userAccount);
    }
    
    @Override
    public List<UserAccount> getAllUserAccounts() {
        return repo.findAll();
    }
    
    @Override
    public UserAccount getUserAccountById(Long id) {
        return repo.findById(id).orElse(null);
    }
    
    @Override
    public UserAccount updateUserAccount(Long id, UserAccount userAccount) {
        userAccount.setId(id);
        return repo.save(userAccount);
    }
    
    @Override
    public void deleteUserAccount(Long id) {
        repo.deleteById(id);
    }
}
