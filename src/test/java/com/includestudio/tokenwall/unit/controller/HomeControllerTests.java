package com.includestudio.tokenwall.unit.controller;

import com.includestudio.tokenwall.interfaces.web.HomeController;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Since: 5/15/12
 */
public class HomeControllerTests {

    @Test
    public void should_return_home_if_request_home_page() throws Exception {
        HomeController controller = new HomeController();
        String viewId = controller.home();
        assertThat(viewId, is("home/home"));
    }
}
