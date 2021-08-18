package com.Backend.Application.IngredientApplication;

import com.Backend.Domain.IngredientDomain.Ingredient;

import java.util.UUID;

public class IngredientService {
    //crear el input DTO
    public static Ingredient create(CreateOrUpdateIngredientDTO dto){
        Ingredient ingredient = new Ingredient();
        ingredient.id = UUID.randomUUID();
        ingredient.name = dto.name;
        ingredient.price = dto.price;
        return ingredient; //va al repositorio
    }
    //crear el output DTO
    public static IngredientDTO createDTO(Ingredient ingredient) {
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.id = ingredient.id;
        ingredientDTO.name = ingredient.name;
        ingredientDTO.price = ingredient.price;
        return ingredientDTO; // ---> controlador
    }
}