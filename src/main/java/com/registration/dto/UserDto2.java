package com.registration.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto2 {

	
	@NotEmpty(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Mobile number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number must be 10 digits")
    private String mobileNo;

    @NotEmpty(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotEmpty(message = "Confirm password is required")
    private String confirmPassword;

    private boolean has1, has2, has3, has4;

    public boolean passwordsMatch() {
        return this.password.equals(this.confirmPassword);
    }

    public boolean isMissingNumbers() {
        return !has1 || !has2 || !has3 || !has4;
    }
}
