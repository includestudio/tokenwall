package com.includestudio.tokenwall.infrastructure.config;

import com.includestudio.tokenwall.application.AuthenticationService;
import com.includestudio.tokenwall.application.impl.AuthenticationServiceImpl;
import com.includestudio.tokenwall.domain.model.user.UserRepository;
import com.includestudio.tokenwall.application.UserService;
import com.includestudio.tokenwall.application.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Since: 5/21/12
 */
@Configuration
public class ServiceConfig {

    private UserRepository userRepository;

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    public AuthenticationService authenticationService() {
        AuthenticationServiceImpl authenticationService = new AuthenticationServiceImpl();
        authenticationService.setUserRepository(userRepository);
        return authenticationService;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
