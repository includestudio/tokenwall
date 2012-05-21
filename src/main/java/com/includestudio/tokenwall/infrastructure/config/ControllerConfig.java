package com.includestudio.tokenwall.infrastructure.config;

import com.includestudio.tokenwall.interfaces.web.HomeController;
import com.includestudio.tokenwall.interfaces.web.RegisterController;
import com.includestudio.tokenwall.interfaces.web.WelcomeController;
import com.includestudio.tokenwall.application.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Since: 5/21/12
 */
@Configuration
public class ControllerConfig {

    private UserService userService;

    @Bean
    public HomeController homeController() {
        return new HomeController();
    }

    @Bean
    public WelcomeController welcomeController() {
        return new WelcomeController();
    }

    @Bean
    public RegisterController registerController() {
        RegisterController registerController = new RegisterController();
        registerController.setUserService(userService);
        return registerController;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
