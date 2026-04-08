package com.tap.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tap.entity.Account;
import com.tap.entity.User;
import com.tap.repository.AccountRepository;
import com.tap.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    // register user
    public User registerUser(User user) {
        User savedUser = userRepository.save(user);

        // create account automatically
        accountService.createAccount(savedUser.getId());

        return savedUser;
    }

    // login user (basic version)
    

    public Map<String, Object> loginUser(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {

            Account account = accountRepository.findByUser(user);

            Map<String, Object> response = new HashMap<>();
            response.put("id", user.getId());
            response.put("name", user.getName());
            response.put("email", user.getEmail());
            response.put("accountNumber", account.getAccountNumber()); // 🔥 KEY LINE

            return response;
        }

        return null;
    }
    
    
}