package com.example.demo.Application.UserApplication;

import javax.validation.constraints.*;
import org.springframework.validation.annotation.Validated;
import lombok.*;

@Validated
public @NoArgsConstructor @Getter @Setter class     UpdateUserDTO {
    @NotBlank(message = "Name error.")
    private String name;
    @NotBlank(message = "Surname error.")
    private String surname;
    @NotNull(message = "Password can't be null.")
    private String password;
}