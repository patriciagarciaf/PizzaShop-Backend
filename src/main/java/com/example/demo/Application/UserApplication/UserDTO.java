package com.example.demo.Application.UserApplication;

import java.util.UUID;

import com.example.demo.Domain.UserDomain.Roles;

import lombok.*;

public @NoArgsConstructor @Getter @Setter class UserDTO {
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Roles role;
}
