package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.registration.dto.UserDto1;
import com.registration.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController1 {

	@Autowired
    private UserService userService;

    @GetMapping("/signup1")
    public String showSignUpForm(Model model) {
        model.addAttribute("user1", new UserDto1());
        return "signup1";
    }

    @PostMapping("/signup1")
    public String handleSignUp(@ModelAttribute("user1") @Valid UserDto1 user1DTO, BindingResult result, Model model) {
        if (!user1DTO.passwordsMatch()) {
            result.rejectValue("confirmPassword", "error.user1", "Passwords do not match");
        }

        if (result.hasErrors()) {
            return "signup1";
        }

        try {
            userService.saveUser(user1DTO);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred while processing your request.");
            return "signup1";
        }

        model.addAttribute("user1", user1DTO);
        return "submittedInfo1";
    }
}
