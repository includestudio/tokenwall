package com.includestudio.tokenwall.application.impl;

import com.includestudio.tokenwall.application.AuthenticationService;
import com.includestudio.tokenwall.domain.model.user.User;
import com.includestudio.tokenwall.domain.model.user.UserRepository;

/**
 * Since: 7/4/12
 */
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            return false;
        }

        if (!user.verifyPassword(password)) {
            return false;
        }

        return true;
    }
}
