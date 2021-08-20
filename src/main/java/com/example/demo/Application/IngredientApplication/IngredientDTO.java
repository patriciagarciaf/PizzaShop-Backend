package com.example.demo.Application.IngredientApplication;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @NoArgsConstructor @Getter @Setter  class IngredientDTO {
    private UUID id;
    private String name;
    private Float price;
}