package com.github.kbednarz.issuetrackingsystem.service.auth;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
