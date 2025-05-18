package com.example.SpringSecurity.service;

import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.model.UserPrincipal;
import com.example.SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = repository.findByUsername(username);
        if(u==null)
            throw new UsernameNotFoundException("User: 404");
        return new UserPrincipal(u);
    }
}
