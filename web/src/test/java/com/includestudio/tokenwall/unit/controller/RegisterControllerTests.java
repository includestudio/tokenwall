package com.includestudio.tokenwall.unit.controller;

import com.includestudio.tokenwall.controller.RegisterController;
import com.includestudio.tokenwall.domain.User;
import com.includestudio.tokenwall.service.UserService;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.easymock.EasyMock.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Since: 5/14/12
 */
public class RegisterControllerTests {

    @Test
    public void should_return_register_if_request_register_page() throws Exception {
        RegisterController controller = new RegisterController();
        String viewId = controller.show();
        assertThat(viewId, is("register/register"));
    }

    @Test
    public void should_return_success_if_valid_register() throws Exception {
        RegisterController controller = new RegisterController();

        UserService userService = createMock(UserService.class);
        controller.setUserService(userService);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("username", "testuser");
        request.addParameter("password", "pa33w0rd");
        request.addParameter("confirm", "pa33w0rd");

        userService.register(new User("testuser", "pa33w0rd"));

        replay(userService);

        String viewId = controller.register(request);

        verify(userService);

        assertThat(viewId, is("register/success"));
    }

    @Test
    public void should_return_fail_if_confirm_password_not_matching() throws Exception {
        RegisterController controller = new RegisterController();

        UserService userService = createMock(UserService.class);
        controller.setUserService(userService);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("username", "testuser");
        request.addParameter("password", "pa33w0rd");
        request.addParameter("confirm", "pa33w0r4");

        replay(userService);

        String viewId = controller.register(request);

        verify(userService);

        assertThat(viewId, is("register/fail"));
    }

}
