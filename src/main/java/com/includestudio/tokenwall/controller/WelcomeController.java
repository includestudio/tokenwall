package com.includestudio.tokenwall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Since: 5/5/12
 */
@Controller
public class WelcomeController {

    @RequestMapping(value = "/welcome", method = GET)
    public String welcome() {
        return "welcome";
    }
}
