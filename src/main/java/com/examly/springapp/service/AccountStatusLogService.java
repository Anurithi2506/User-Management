package com.examly.springapp.service;

import com.examly.springapp.model.AccountStatusLog;

import java.util.List;

public interface AccountStatusLogService {
    AccountStatusLog saveAccountStatusLog(AccountStatusLog accountStatusLog);
    List<AccountStatusLog> getAllAccountStatusLogs();
    AccountStatusLog getAccountStatusLogById(Long id);
    AccountStatusLog updateAccountStatusLog(Long id, AccountStatusLog accountStatusLog);
    void deleteAccountStatusLog(Long id);
}
