package com.example.demo.Application.CommentApplication;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class CreateDTOComment {
    @Valid
    
    @NotBlank
    @Size(max=2000)
    public String text;
    @Min(0)
    @Max(5)
    public int score;
}
