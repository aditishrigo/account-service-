package com.maveric.bank.Service;
import com.maveric.bank.exception.AccountNotFoundException;
import com.maveric.bank.model.Account;
import com.maveric.bank.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    private static final String ACCOUNTUPDATESUCCESS = "ACCOUNT_UPDATE_SUCCESS";
    private static final String ACCOUNTUPDATEFAILED = "ACCOUNT_UPDATE_FAILED";
    private static final String ACCOUNTNOTFOUND = "Account not in system";

    AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }


    @Override
    public Account createAccountData(Account account) {
        repository.save(account);
        return account;
    }


}