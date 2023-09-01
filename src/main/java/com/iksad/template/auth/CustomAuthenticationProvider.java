package com.iksad.template.auth;

import com.iksad.template.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 인증 여부 확인
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        Optional<UserDetails> optionalUserDetails = customUserDetailsService.loadUserBySomething(username, password);
        UserDetails principal = optionalUserDetails.orElseThrow(() -> new IllegalArgumentException("유저가 없거나 비밀 번호가 틀렸을 수 있음."));

        // 인증 객체로 리뉴얼
        return CustomAuthenticationToken.authenticated(principal, principal.getPassword(), principal.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(CustomAuthenticationToken.class);
    }
}
