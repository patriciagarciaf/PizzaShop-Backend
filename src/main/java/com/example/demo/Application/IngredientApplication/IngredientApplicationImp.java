package com.example.demo.Application.IngredientApplication;

import com.example.demo.Domain.IngredientDomain.*;
import com.example.demo.core.ApplicationBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;

import java.util.*;

@Service
public class IngredientApplicationImp extends ApplicationBase<Ingredient, UUID> implements IngredientApplication {

    private final IngredientRepositoryWrite ingredientRepositoryWrite;
    private final IngredientRepositoryRead ingredientRepositoryRead;
    private final ModelMapper modelMapper;
    private final Logger logger;

    @Autowired
    public IngredientApplicationImp(final IngredientRepositoryWrite ingredientRepositoryWrite,
                                    final IngredientRepositoryRead ingredientRepositoryRead,
                                    final ModelMapper modelMapper,
                                    final Logger logger){

        super((id) -> ingredientRepositoryWrite.findById(id));
        
        this.ingredientRepositoryWrite = ingredientRepositoryWrite;
        this.ingredientRepositoryRead = ingredientRepositoryRead;
        this.modelMapper = modelMapper;
        this.logger = logger;
    }

    @Override
    public IngredientDTO add(CreateOrUpdateIngredientDTO dto) {

        Ingredient ingredient = modelMapper.map(dto, Ingredient.class);
        ingredient.setId(UUID.randomUUID());
        ingredient.validate("name", ingredient.getName(), (name)-> this.ingredientRepositoryWrite.exists(name));

        this.ingredientRepositoryWrite.add(ingredient);
        logger.info(this.serializeObject(ingredient, "added."));

        return modelMapper.map(ingredient, IngredientDTO.class);
    }

    @Override
    public IngredientDTO get(UUID id) {

        Ingredient ingredient = this.findById(id);
        return this.modelMapper.map(ingredient, IngredientDTO.class);
    }

    @Override
    public void update(UUID id, CreateOrUpdateIngredientDTO dtos) {
       
        Ingredient ingredient = modelMapper.map(dtos, Ingredient.class);
        ingredient.setId(this.findById(id).getId());
        //TODO: Verify the handling of constraintvalidationnerror
        //ingredient.validate("name", ingredient.getName(), (name)-> this.ingredientWriteRepository.exists(name));
        ingredient.validate();
        this.ingredientRepositoryWrite.update(ingredient);
        logger.info(this.serializeObject(ingredient, "updated."));
    }

    @Override
    public void delete(UUID id) {

        Ingredient ingredient = this.findById(id);
        this.ingredientRepositoryWrite.delete(ingredient);
        logger.info(this.serializeObject(ingredient, "deleted."));
    }

    @Override
    public List<IngredientProjection> getAll(String name, int page, int size) {
        return this.ingredientRepositoryRead.getAll(name, page, size);
    }

    private String serializeObject(Ingredient ingredient, String msg){
        
        return String.format("Ingredient {id: %s, name: %s, price: %s} has been %s succesfully.",
                            ingredient.getId(), ingredient.getName(),
                            ingredient.getPrice().toString(),
                            msg);
    }
}
