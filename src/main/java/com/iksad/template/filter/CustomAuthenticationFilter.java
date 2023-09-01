package com.iksad.template.filter;

import com.iksad.template.auth.CustomAuthenticationToken;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public CustomAuthenticationFilter(String urlWhenRunningAuthenticatingProcess, AuthenticationManager authenticationManager) {
        super(urlWhenRunningAuthenticatingProcess);
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        CustomAuthenticationToken unauthenticatedToken = obtainToken(request);

        return getAuthenticationManager().authenticate(unauthenticatedToken);
    }

    private CustomAuthenticationToken obtainToken(HttpServletRequest request) {
        String username = request.getHeader("username");
        String password = request.getHeader("password");

        return CustomAuthenticationToken.unauthenticated(username, password);
    }
}