package com.includestudio.tokenwall.unit.controller;

import com.includestudio.tokenwall.interfaces.web.RegisterController;
import com.includestudio.tokenwall.domain.model.user.User;
import com.includestudio.tokenwall.application.UserService;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

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

        Model model = new ExtendedModelMap();
        String viewId = controller.register(model, request);

        verify(userService);

        assertThat(viewId, is("register/success"));
    }

    @Test
    public void should_return_register_and_set_error_if_confirm_password_not_matching() throws Exception {
        RegisterController controller = new RegisterController();

        UserService userService = createMock(UserService.class);
        controller.setUserService(userService);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("username", "testuser");
        request.addParameter("password", "pa33w0rd");
        request.addParameter("confirm", "pa33w0r4");

        ExtendedModelMap model = new ExtendedModelMap();

        replay(userService);

        String viewId = controller.register(model,request);

        verify(userService);

        assertThat(viewId, is("register/register"));
        assertThat((String) model.get("error"), is("Confirm password not matching"));
    }

}
