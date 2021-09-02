package com.example.demo.Application.PizzaApplication;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.example.demo.Application.ImageApplication.ImageDTO;
import com.example.demo.Domain.IngredientDomain.Ingredient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @NoArgsConstructor @Getter @Setter
class PizzaDTO {

    private UUID id;

    private String name;

    private ImageDTO imageDTO;

    private BigDecimal price;

    private Set<Ingredient> ingredients = new HashSet<Ingredient>();
}
