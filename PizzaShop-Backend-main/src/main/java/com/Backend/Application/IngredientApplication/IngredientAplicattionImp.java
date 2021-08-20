package com.Backend.Application.IngredientApplication;

import com.Backend.Domain.IngredientDomain.Ingredient;
import com.Backend.Domain.IngredientDomain.IngredientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
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
        ingredient.setId(UUID.randomUUID());
        ingredient.validate();
        this.ingredientRepository.add(ingredient);
        return modelMapper.map(ingredient, IngredientDTO.class);
    }
}
