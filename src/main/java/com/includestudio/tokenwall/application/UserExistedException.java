package com.includestudio.tokenwall.application;

/**
 * Since: 5/13/12
 */
public class UserExistedException extends RuntimeException {

    private String username;

    public UserExistedException(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
