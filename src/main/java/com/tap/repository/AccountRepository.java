package com.tap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tap.entity.Account;
import com.tap.entity.User;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByAccountNumber(String accountNumber);
    Account findByUser(User user);
}