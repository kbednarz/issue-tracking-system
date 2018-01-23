package com.github.kbednarz.issuetrackingsystem.repository.auth;

import com.github.kbednarz.issuetrackingsystem.domain.auth.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}