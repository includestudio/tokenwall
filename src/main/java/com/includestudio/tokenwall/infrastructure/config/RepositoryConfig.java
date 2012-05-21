package com.includestudio.tokenwall.infrastructure.config;

import com.includestudio.tokenwall.domain.model.user.UserRepository;
import com.includestudio.tokenwall.infrastructure.persistence.hibernate.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Since: 5/21/12
 */
@Configuration
public class RepositoryConfig {

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl();
    }
}
