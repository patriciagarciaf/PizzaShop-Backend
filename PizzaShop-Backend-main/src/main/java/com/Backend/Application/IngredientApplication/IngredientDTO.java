package com.Backend.Application.IngredientApplication;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

public @NoArgsConstructor @Getter @Setter
class IngredientDTO {
    private UUID id;
    private String name;
    private Float price;
}