package com.maveric.bank.controller;
import com.maveric.bank.Service.AccountServiceImpl;
import com.maveric.bank.model.AccountDto;
import com.maveric.bank.model.Account;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    ModelMapper modelMapper;
    private final AccountServiceImpl AccountService;

    AccountController(AccountServiceImpl AccountService) {
        this.AccountService = AccountService;
    }



    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@Valid @RequestBody AccountDto AccountDto) {
        Account account = convertToEntity(AccountDto);
        //return new ResponseEntity<>(AccountService.createAccountData(account), HttpStatus.CREATED);
        return new ResponseEntity<>(AccountService.createAccountData(account),HttpStatus.CREATED);
    }


    private Account convertToEntity(AccountDto accountDto) {
        return modelMapper.map(accountDto, Account.class);

    }

}
