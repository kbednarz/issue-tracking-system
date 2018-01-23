package com.github.kbednarz.issuetrackingsystem.service.auth;

import com.github.kbednarz.issuetrackingsystem.domain.auth.Role;
import com.github.kbednarz.issuetrackingsystem.domain.auth.User;
import com.github.kbednarz.issuetrackingsystem.repository.auth.RoleRepository;
import com.github.kbednarz.issuetrackingsystem.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>((List<Role>) roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}