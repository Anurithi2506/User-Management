package com.examly.springapp.service;

import com.examly.springapp.model.AccountStatusLog;
import com.examly.springapp.repository.AccountStatusLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountStatusLogServiceImpl implements AccountStatusLogService {
    
    @Autowired
    private AccountStatusLogRepo repo;
    
    @Override
    public AccountStatusLog saveAccountStatusLog(AccountStatusLog accountStatusLog) {
        return repo.save(accountStatusLog);
    }
    
    @Override
    public List<AccountStatusLog> getAllAccountStatusLogs() {
        return repo.findAll();
    }
    
    @Override
    public AccountStatusLog getAccountStatusLogById(Long id) {
        return repo.findById(id).orElse(null);
    }
    
    @Override
    public AccountStatusLog updateAccountStatusLog(Long id, AccountStatusLog accountStatusLog) {
        accountStatusLog.setId(id);
        return repo.save(accountStatusLog);
    }
    
    @Override
    public void deleteAccountStatusLog(Long id) {
        repo.deleteById(id);
    }
}
