package com.includestudio.tokenwall.unit.domain;

import com.includestudio.tokenwall.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.lang.reflect.Field;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * Since: 5/13/12
 */
public class UserTests {


    private String password;
    private String username;
    private User user;

    @Before
    public void setUp() throws Exception {
        password = "pa33w0rd";
        username = "mike";
        user = new User(username, password);
    }

    @Test
    public void should_retrieve_username() throws Exception {
        assertThat(user.getUsername(), is(username));

    }

    @Test
    public void should_encrypt_password_in_md5_hex_string() throws Exception {
        String actualPassword = retrievePasswordViaReflection(user);
        assertThat(actualPassword, is(md5hex(password)));
    }

    @Test
    public void should_equal_if_same_username() throws Exception {
        User mike = new User("mike", "password");
        User mikeToo = new User("mike", "password3");
        assertThat(mike, is(mikeToo));
    }

    @Test
    public void should_not_equal_if_different_usernames() throws Exception {
        User mike = new User("mike", "password");
        User john = new User("john", "password3");
        assertThat(mike, not(john));
    }

    private String retrievePasswordViaReflection(User user) throws NoSuchFieldException, IllegalAccessException {
        Field passworField = user.getClass().getDeclaredField("password");
        passworField.setAccessible(true);
        return (String) passworField.get(user);
    }

    private String md5hex(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
