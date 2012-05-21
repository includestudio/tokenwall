package com.includestudio.tokenwall.domain.model.user;

/**
 * Since: 5/13/12
 */
public interface UserRepository {

    User findByUsername(String username);

    void store(User mike);
}
