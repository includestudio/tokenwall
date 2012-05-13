package com.includestudio.tokenwall.service;

import com.includestudio.tokenwall.domain.User;
import com.includestudio.tokenwall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Since: 5/13/12
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(User user) {
        User existedUser = userRepository.findByUsername(user.getUsername());
        if(existedUser != null)
            throw new UserExistedException(user.getUsername());

        userRepository.store(user);
    }
}
