package com.includestudio.tokenwall.application;

/**
 * Since: 7/5/12
 */
public interface AuthenticationService {
    Boolean authenticate(String username, String password);
}
