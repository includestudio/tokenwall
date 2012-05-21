package com.includestudio.tokenwall.infrastructure.config;

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

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
