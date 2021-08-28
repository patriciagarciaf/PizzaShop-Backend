package com.example.demo.Application.ImageApplication;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @Getter @Setter @NoArgsConstructor class CreateOrUpdateImageDTO {
    
    @NotBlank
    public byte[] data;
}
