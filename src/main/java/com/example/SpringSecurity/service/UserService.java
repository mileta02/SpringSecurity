package com.example.SpringSecurity.service;

import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
