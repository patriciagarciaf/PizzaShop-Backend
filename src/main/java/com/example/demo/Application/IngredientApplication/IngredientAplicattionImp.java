package com.example.demo.Application.IngredientApplication;

import com.example.demo.Domain.IngredientDomain.Ingredient;
import com.example.demo.Domain.IngredientDomain.IngredientRepository;


import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;

import java.util.UUID;

@Service
public class IngredientAplicattionImp implements IngredientAplicattion{

    private final Logger log;
    private final IngredientRepository ingredientRepository;

    IngredientAplicattionImp(final Logger log, final IngredientRepository ingredientRepository) {
        this.log = log;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientDTO add(CreateOrUpdateIngredientDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Ingredient ingredient = modelMapper.map(dto, Ingredient.class);
        ingredient.id=UUID.randomUUID();
        //validar
        this.ingredientRepository.add(ingredient);
        return modelMapper.map(ingredient, IngredientDTO.class);
    }
}
