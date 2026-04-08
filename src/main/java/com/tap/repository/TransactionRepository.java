package com.tap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tap.entity.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // for transaction history later
    List<Transaction> findByFromAccountOrToAccount(String from, String to);
    
}