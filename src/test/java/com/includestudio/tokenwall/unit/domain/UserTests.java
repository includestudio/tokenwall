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

    private User mike;

    @Before
    public void setUp() throws Exception {
        mike = new User("mike", "password");
    }

    @Test
    public void password_verify_return_true_when_provided_password_matching() throws Exception {
        assertThat(mike.verifyPassword("password"), is(true));
    }

    @Test
    public void password_verify_return_true_when_provided_password_not_matching() throws Exception {
        assertThat(mike.verifyPassword("pass"), is(false));
    }

    @Test
    public void should_encrypt_password_in_md5_hex_string() throws Exception {
        String actualPassword = retrievePasswordViaReflection(mike);
        assertThat(actualPassword, is(md5hex("password")));
    }

    @Test
    public void should_equal_if_same_username() throws Exception {
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
