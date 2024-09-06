package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.registration.dto.UserDto;
import com.registration.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "signup";
    }

    @PostMapping("/signup")
    public String handleSignUp(@ModelAttribute("user") @Valid UserDto userDTO, BindingResult result, Model model) {
        if (!userDTO.passwordsMatch()) {
            result.addError(new FieldError("user", "confirmPassword", "Passwords do not match"));
        }

        if (result.hasErrors()) {
            return "signup";
        }

        try {
            userService.saveUser(userDTO);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred while processing your request.");
            return "signup";
        }

        model.addAttribute("user", userDTO);
        return "submittedInfo";
    }
}
