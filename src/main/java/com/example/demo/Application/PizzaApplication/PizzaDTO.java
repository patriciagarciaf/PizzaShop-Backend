package com.example.demo.Application.PizzaApplication;

import com.example.demo.Domain.IngredientDomain.Ingredient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public @NoArgsConstructor @Getter @Setter
class PizzaDTO {
    public UUID id;
    public String name;
    public String description;
    public Set<Ingredient> ingredients = new HashSet<Ingredient>();
}
