package com.iksad.template.service;

import com.iksad.template.model.MockUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MockCustomUserDetailsService implements CustomUserDetailsService {
    @Override
    public Optional<UserDetails> loadUserBySomething(String username, String password) {
        return Optional.of(new MockUserDetails());
    }
}
