package com.includestudio.tokenwall.unit.domain;

import com.includestudio.tokenwall.domain.model.user.User;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.ClosureUtils;
import org.apache.commons.collections.PredicateUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.lang.reflect.Field;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Since: 5/13/12
 */
public class UserTests {

    @Test
    public void should_Name() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void should_retrieve_username() throws Exception {
        String username = "mike";
        User mike = new User(username, "password");
        assertThat(mike.getUsername(), is(username));

    }

    @Test
    public void should_encrypt_password_in_md5_hex_string() throws Exception {
        String password = "password";
        User mike = new User("mike", password);
        String actualPassword = retrievePasswordViaReflection(mike);
        assertThat(actualPassword, is(md5hex(password)));
    }

    @Test
    public void should_equal_if_same_username() throws Exception {
        User mike = new User("mike","kdfjksdjfkds");
        User anotherMike = new User("mike", "password3");
        assertThat(anotherMike, is(mike));
    }

    @Test
    public void should_not_equal_if_different_usernames() throws Exception {
        User mike = new User("mike", "password");
        User john = new User("john", "password");
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
