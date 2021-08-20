package com.Backend.Application.IngredientApplication;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @NoArgsConstructor @Getter @Setter
class CreateOrUpdateIngredientDTO {
    public String name;
    public Float price;
}
