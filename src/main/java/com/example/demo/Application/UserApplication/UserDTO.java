package com.example.demo.Application.UserApplication;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @NoArgsConstructor @Getter @Setter class UserDTO {

    private String text;
    private Date date;
    private int score;
}
