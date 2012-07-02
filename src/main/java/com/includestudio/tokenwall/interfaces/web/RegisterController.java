package com.includestudio.tokenwall.interfaces.web;

import com.includestudio.tokenwall.application.UserService;
import com.includestudio.tokenwall.domain.model.user.User;
import com.includestudio.tokenwall.interfaces.web.command.RegisterCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Since: 5/14/12
 */
@Controller
@RequestMapping("/users")
public class RegisterController {

    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("command", new RegisterCommand());
        return "users/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("command") @Valid RegisterCommand command, Model model, HttpServletRequest request) {

        String username = command.getUsername();
        String password = command.getPassword();
        String confirmPassword = command.getPasswordConfirm();

        if (username.contains(" ")) {
            model.addAttribute("error", "Spaces are not allowed in user name");
            return "users/register";
        }

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Confirm password not matching");
            return "users/register";
        }


        User user = new User(username, password);

        userService.register(user);

        return "users/success";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
