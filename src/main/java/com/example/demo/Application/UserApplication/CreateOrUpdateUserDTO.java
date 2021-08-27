package com.example.demo.Application.UserApplication;

import javax.validation.constraints.*;

import com.example.demo.Domain.UserDomain.Roles;

import org.springframework.validation.annotation.Validated;

import lombok.*;

@Validated
public @NoArgsConstructor @Getter @Setter   class CreateOrUpdateUserDTO {
    @NotBlank (message="Name error.")
    private String name;
    @NotBlank (message="Surname error.")
    private String surname;
    @Email (message="Dude, you messed up the email.")
    private String email;
    private String password;
    private Roles role;
}