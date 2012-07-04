package com.includestudio.tokenwall.unit.application;

import com.includestudio.tokenwall.application.impl.AuthenticationServiceImpl;
import com.includestudio.tokenwall.domain.model.user.User;
import com.includestudio.tokenwall.domain.model.user.UserRepository;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Since: 7/4/12
 */
public class AuthenticationServiceTest {

    private AuthenticationServiceImpl authenticationService;
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        authenticationService = new AuthenticationServiceImpl();
        userRepository = createMock(UserRepository.class);
        authenticationService.setUserRepository(userRepository);
    }

    @Test
    public void should_succeed_when_right_credential() throws Exception {
        String username = "mike";
        String password = "password";

        expect(userRepository.findByUsername(username)).andReturn(new User(username, password));

        replay(userRepository);

        Boolean result = authenticationService.authenticate(username, password);

        verify(userRepository);

        assertThat(result, is(true));

    }

    @Test
    public void should_fail_when_user_not_found() throws Exception {
        String username = "mike";
        String password = "password";

        expect(userRepository.findByUsername(username)).andReturn(null);

        replay(userRepository);

        Boolean result = authenticationService.authenticate(username, password);

        verify(userRepository);

        assertThat(result, is(false));

    }

    @Test
    public void should_fail_when_wrong_password() throws Exception {
        String username = "mike";
        String password = "password";

        expect(userRepository.findByUsername(username)).andReturn(new User(username, password));

        replay(userRepository);

        Boolean result = authenticationService.authenticate(username, "wrongpass");

        verify(userRepository);

        assertThat(result, is(false));

    }
}
