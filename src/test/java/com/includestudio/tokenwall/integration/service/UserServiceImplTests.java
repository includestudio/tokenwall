package com.includestudio.tokenwall.integration.service;

import com.includestudio.tokenwall.domain.model.user.User;
import com.includestudio.tokenwall.domain.model.user.UserRepository;
import com.includestudio.tokenwall.application.UserExistedException;
import com.includestudio.tokenwall.application.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Since: 5/13/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml"})
public class UserServiceImplTests {

    private UserService userService;

    private UserRepository userRepository;

    @Test
    public void should_register_user_sucessfully() throws Exception {

        User mike = new User("mike", "pa33w0rd");
        userService.register(mike);

        User registeredMike = userRepository.findByUsername(mike.getUsername());

        assertThat(registeredMike, not(nullValue()));
        assertThat(registeredMike.getUsername(), is(mike.getUsername()));
    }

    @Test
    public void should_throw_user_existed_exception_if_username_already_exits() throws Exception {

        User mike = new User("mike", "pa33w0rd");
        userRepository.store(mike);


        try {
            userService.register(mike);
            fail();
        } catch (UserExistedException uee) {
             assertThat(uee.getUsername(),is(mike.getUsername()));
        }
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
