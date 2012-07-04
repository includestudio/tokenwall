package com.includestudio.tokenwall.infrastructure.security;

import com.includestudio.tokenwall.application.AuthenticationService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

/**
 * Since: 7/5/12
 */
public class UsernameAndPasswordAuthenticationProvider implements AuthenticationProvider {

    private AuthenticationService authenticationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String principal = (String) authentication.getPrincipal();
        String credentials = (String) authentication.getCredentials();

        if (!authenticationService.authenticate(principal, credentials)) {
            throw new BadCredentialsException("user name or password is not correct");
        }

        return new UsernamePasswordAuthenticationToken(principal, credentials, Collections.singleton(new SimpleGrantedAuthority("ROLE_ANY")));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}
