package com.Backend.Application.CommentApplication;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateDTOComment {
    @NotBlank
    @Size(max=2000)
    public String text;
    @Min(0)
    @Max(5)
    public int score;
}
