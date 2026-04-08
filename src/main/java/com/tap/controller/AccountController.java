package com.tap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tap.entity.Account;
import com.tap.entity.Transaction;
import com.tap.service.AccountService;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "http://localhost:5173")
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    


    @PostMapping("/create/{userId}")
    public Account createAccount(@PathVariable Long userId) {
        return accountService.createAccount(userId);
    }

    @PostMapping("/deposit")
    public Account deposit(@RequestParam String accountNumber,
                           @RequestParam double amount) {
        return accountService.deposit(accountNumber, amount);
    }
    
    
    @PostMapping("/withdraw")
    public Account withdraw(@RequestParam String accountNumber,
                            @RequestParam double amount) {
        return accountService.withdraw(accountNumber, amount);
    }
    
    @PostMapping("/transfer")
    public String transfer(@RequestParam String fromAcc,
                           @RequestParam String toAcc,
                           @RequestParam double amount) {

        return accountService.transfer(fromAcc, toAcc, amount);
    }
    
    @GetMapping("/transactions")
    public List<Transaction> getTransactions(@RequestParam String account) {
        return accountService.getTransactions(account);
    }
}