package com.github.kbednarz.issuetrackingsystem.service.auth;

import com.github.kbednarz.issuetrackingsystem.domain.auth.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}