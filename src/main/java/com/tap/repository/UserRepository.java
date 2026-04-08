package com.tap.repository;

import com.tap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // custom query (we will use for login later)
    User findByEmail(String email);
}