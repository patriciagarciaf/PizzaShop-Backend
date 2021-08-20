package com.example.demo.Application.IngredientApplication;

import com.example.demo.Domain.IngredientDomain.Ingredient;
import com.example.demo.Domain.IngredientDomain.IngredientRepository;


import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;

import java.util.UUID;

@Service
public class IngredientApplicationImp implements IngredientApplication{

    private final Logger log;
    private final IngredientRepository ingredientRepository;

    IngredientApplicationImp(final Logger log, final IngredientRepository ingredientRepository) {
        this.log = log;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientDTO add(CreateOrUpdateIngredientDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Ingredient ingredient = modelMapper.map(dto, Ingredient.class);
        ingredient.id=UUID.randomUUID();
        ingredient.validate();
        this.ingredientRepository.add(ingredient);
        return modelMapper.map(ingredient, IngredientDTO.class);
    }
}
