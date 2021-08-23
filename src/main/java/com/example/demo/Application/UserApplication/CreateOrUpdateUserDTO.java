package com.example.demo.Application.UserApplication;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.example.demo.Domain.UserDomain.Roles;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Validated
public @NoArgsConstructor @Getter @Setter   class CreateOrUpdateUserDTO {
    @NotBlank
    private String name;
    private String surname;
    @Email
    private String email;
    private String password;
    private Roles role;
}