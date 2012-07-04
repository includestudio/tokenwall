package com.includestudio.tokenwall.infrastructure.config;

import com.includestudio.tokenwall.application.AuthenticationService;
import com.includestudio.tokenwall.infrastructure.security.UsernameAndPasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;

/**
 * Since: 7/5/12
 */
@Configuration
public class SecurityConfig {

    private AuthenticationService authenticationService;

    @Bean
    public AuthenticationProvider authenticationProvider(){
        UsernameAndPasswordAuthenticationProvider provider = new UsernameAndPasswordAuthenticationProvider();
        provider.setAuthenticationService(authenticationService);
        return provider;
    }

    @Autowired
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}
