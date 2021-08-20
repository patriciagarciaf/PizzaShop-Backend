package com.example.demo.Application.UserApplication;

import com.example.demo.Domain.UserDomain.Roles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @NoArgsConstructor @Getter @Setter   class CreateOrUpdateUserDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Roles role;
}