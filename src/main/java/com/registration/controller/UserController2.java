package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.registration.dto.UserDto2;
import com.registration.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController2 {

	@Autowired
    private UserService userService;

    @GetMapping("/signup2")
    public String showSignUpForm(Model model) {
        model.addAttribute("user2", new UserDto2());
        return "signup2";
    }

    @PostMapping("/signup2")
    public String handleSignUp(@ModelAttribute("user2") @Valid UserDto2 user2DTO, BindingResult result, Model model) {
        if (!user2DTO.passwordsMatch()) {
            result.rejectValue("confirmPassword", "error.user2", "Passwords do not match");
        }

        if (result.hasErrors()) {
            return "signup2";
        }

        try {
            userService.saveUser(user2DTO);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred while processing your request.");
            return "signup2";
        }

        model.addAttribute("user2", user2DTO);

        if (user2DTO.isMissingNumbers()) {
            model.addAttribute("missingNumbersMessage", "You are missing the numbers 5, 6, 7, 8, and 9 compared to User1.");
        }

        return "submittedInfo2";
    }
}
