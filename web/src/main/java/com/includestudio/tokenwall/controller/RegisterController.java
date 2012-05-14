package com.includestudio.tokenwall.controller;

import com.includestudio.tokenwall.domain.User;
import com.includestudio.tokenwall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Since: 5/14/12
 */
@Controller
public class RegisterController {

    private UserService userService;

    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String show() {
        return "register/register";
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String register(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm");

        if(!password.equals(confirmPassword))
            return "register/fail";

        User user = new User(username, password);

        userService.register(user);

        return "register/success";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
