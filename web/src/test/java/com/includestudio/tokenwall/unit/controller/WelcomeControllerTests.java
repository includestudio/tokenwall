package com.includestudio.tokenwall.unit.controller;

import com.includestudio.tokenwall.controller.WelcomeController;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Since: 5/5/12
 */
public class WelcomeControllerTests {

    @Test
    public void should_return_view_welcome() throws Exception {

        WelcomeController controler = new WelcomeController();
        String viewId = controler.welcome();
        assertThat(viewId, is("welcome"));
    }
}
