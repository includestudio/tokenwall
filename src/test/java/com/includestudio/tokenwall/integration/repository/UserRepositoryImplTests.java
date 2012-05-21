package com.includestudio.tokenwall.integration.repository;

import com.includestudio.tokenwall.domain.model.user.User;
import com.includestudio.tokenwall.domain.model.user.UserRepository;
import com.includestudio.tokenwall.support.RepositoryTestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Since: 5/13/12
 */
@ContextConfiguration(locations = {"classpath:context.xml"})
public class UserRepositoryImplTests extends RepositoryTestBase {

    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        clearTable("USERS");
    }

    @Test
    public void should_return_null_if_matching_username_found() throws Exception {

        User mike = userRepository.findByUsername("mike");
        assertThat(mike, is(nullValue()));
    }

    @Test
    public void should_return_found_user_if_matching_username() throws Exception {
        insertUserInDB("mike");

        User mike = userRepository.findByUsername("mike");

        assertThat(mike, not(nullValue()));
        assertThat(mike.getUsername(), is("mike"));

    }

    private void insertUserInDB(String username) {
        jdbcTemplate.update("INSERT INTO USERS (username,password) VALUES (?,'whateverpassword')", username);
    }

    @Test
    public void should_allow_store_user() throws Exception {
        User mike = new User("mike", "password");

        assertThat(userCountInDB("mike"), is(0));

        userRepository.store(mike);

        assertThat(userCountInDB("mike"), is(1));
    }

    @After
    public void tearDown() throws Exception {
        clearTable("USERS");
    }

    private int userCountInDB(String username) {
        return jdbcTemplate.queryForInt("SELECT COUNT(*) FROM USERS WHERE username = ?", username);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
