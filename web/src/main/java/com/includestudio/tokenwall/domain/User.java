package com.includestudio.tokenwall.domain;

import org.springframework.util.DigestUtils;

import javax.persistence.*;

/**
 * Since: 5/13/12
 */
@Entity
@Table(name = "USERS")
@Access(value = AccessType.FIELD)
public class User {

    @Id
    private String username;

    @Column(nullable = false)
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = DigestUtils.md5DigestAsHex(password.getBytes());
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    protected User(){

    }
}
