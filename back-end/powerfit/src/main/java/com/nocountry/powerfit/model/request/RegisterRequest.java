package com.nocountry.powerfit.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest {

    @Pattern(regexp = "^[A-Za-z]+$", message = "Name must only contain letters")
    @Size(min = 1, max = 10, message = "Please enter a valid name")
    @NotBlank(message = "Name can't be empty.")
    private String name;

    @NonNull
    @Pattern(regexp = "^[A-Za-z]+$", message = "LastName must only contain letters")
    @Size(min = 1, max = 10, message = "Please enter a valid name")
    @NotEmpty(message = "lastName can't be empty")
    @NotBlank(message = "lastName can't be empty.")
    private String lastName;

    @NonNull
    @Pattern(regexp = "\\d{10}", message = "Please enter a valid phone number")
    @NotEmpty(message = "Phone number can't be empty")
    @NotBlank(message = "Phone number can't be empty.")
    private String phoneNumber;

    @NonNull
    @NotEmpty(message = "the full name can't be null")
    @Email(message = "Email should have a valid format")
    @NotBlank(message = "Email cannot be empty.")
    private String email;

    @NotNull(message = "{password.error}")
    @NotBlank(message = "{password.error}")
    @Size(min = 8, max = 250, message = "Password should have at least 8 characters")
    private String password;
}
