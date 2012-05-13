package com.includestudio.tokenwall.repository;

import com.includestudio.tokenwall.domain.User;

/**
 * Since: 5/13/12
 */
public interface UserRepository {

    User findByUsername(String username);

    void store(User mike);
}
