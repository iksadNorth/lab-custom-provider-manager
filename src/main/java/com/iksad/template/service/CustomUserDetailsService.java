package com.iksad.template.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface CustomUserDetailsService {
    Optional<UserDetails> loadUserBySomething(String username, String password);
}
