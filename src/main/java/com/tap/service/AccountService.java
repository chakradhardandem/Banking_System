package com.tap.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tap.entity.Account;
import com.tap.entity.Transaction;
import com.tap.entity.User;
import com.tap.repository.AccountRepository;
import com.tap.repository.TransactionRepository;
import com.tap.repository.UserRepository;

@Service
public class AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TransactionRepository transactionRepository;

    // create account automatically
    public Account createAccount(Long userId) {
        User user = userRepository.findById(userId).get();

        Account account = new Account();
        account.setAccountNumber(UUID.randomUUID().toString());
        account.setBalance(0);
        account.setUser(user);

        return accountRepository.save(account);
    }
    // deposit money
    public Account deposit(String accountNumber, double amount) {
        Account acc = accountRepository.findByAccountNumber(accountNumber);

        acc.setBalance(acc.getBalance() + amount);

        return accountRepository.save(acc);
    }
    
    
    public Account withdraw(String accountNumber, double amount) {

        Account acc = accountRepository.findByAccountNumber(accountNumber);

        if (acc.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }

        acc.setBalance(acc.getBalance() - amount);

        return accountRepository.save(acc);
    }
    
    
    

    @Transactional
    public String transfer(String fromAcc, String toAcc, double amount) {

        Account sender = accountRepository.findByAccountNumber(fromAcc);
        Account receiver = accountRepository.findByAccountNumber(toAcc);

        if (sender == null || receiver == null) {
            throw new RuntimeException("Invalid account");
        }

        if (sender.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        // deduct
        sender.setBalance(sender.getBalance() - amount);

        // add
        receiver.setBalance(receiver.getBalance() + amount);

        accountRepository.save(sender);
        accountRepository.save(receiver);

        // save transaction
        Transaction txn = new Transaction();
        txn.setFromAccount(fromAcc);
        txn.setToAccount(toAcc);
        txn.setAmount(amount);
        txn.setType("TRANSFER");

        transactionRepository.save(txn);

        return "Transfer Successful";
    }
    
 


    public List<Transaction> getTransactions(String account) {

        List<Transaction> all = transactionRepository.findAll();

        return all.stream()
                .filter(t ->
                        account.equals(t.getFromAccount()) ||
                        account.equals(t.getToAccount())
                )
                .toList();
    }
}