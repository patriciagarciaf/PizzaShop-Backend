package com.example.demo.Application.IngredientApplication;

import com.example.demo.Domain.IngredientDomain.Ingredient;
import com.example.demo.Domain.IngredientDomain.IngredientProjection;
import com.example.demo.Domain.IngredientDomain.IngredientRepositoryRead;
import com.example.demo.Domain.IngredientDomain.IngredientRepositoryWrite;


import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;

import java.util.List;
import java.util.UUID;

@Service
public class IngredientApplicationImp implements IngredientApplication{

    private final Logger log;
    private final IngredientRepositoryWrite ingredientRepositoryWrite;
    private final IngredientRepositoryRead ingredientRepositoryRead;
    private ModelMapper modelMapper = new ModelMapper();  //singleton


    IngredientApplicationImp(final Logger log, final IngredientRepositoryWrite ingredientRepositoryWrite, final IngredientRepositoryRead ingredientRepositoryRead) {
        this.log = log;
        this.ingredientRepositoryWrite = ingredientRepositoryWrite;
        this.ingredientRepositoryRead=ingredientRepositoryRead;
    }

    @Override
    public IngredientDTO add(CreateOrUpdateIngredientDTO dto) {
        Ingredient ingredient = modelMapper.map(dto, Ingredient.class);
        ingredient.id=UUID.randomUUID();
        ingredient.validate();
        this.ingredientRepositoryWrite.add(ingredient);
        return modelMapper.map(ingredient, IngredientDTO.class);
    }

    @Override
    public void delete(UUID id) {
        Ingredient ingredient=this.ingredientRepositoryWrite.findById(id).orElseThrow();
        this.ingredientRepositoryWrite.delete(ingredient);
    }

    @Override
    public IngredientDTO get(UUID id) {
        Ingredient ingredient= this.ingredientRepositoryWrite.findById(id).orElseThrow();
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(ingredient, IngredientDTO.class);
    }

    @Override
    public List<IngredientProjection> getAll(String name, int page, int size){
        return this.ingredientRepositoryRead.getAll(name, page, size);
    }

    @Override
    public void update(UUID id, CreateOrUpdateIngredientDTO dto) {
        Ingredient ingredient = modelMapper.map(dto, Ingredient.class);
        ingredient.setId(id);
        ingredient.validate();
        this.ingredientRepositoryWrite.update(ingredient); // el método add del CRUD/JPA compara y actualiza los datos introducidos q no sean iguales
    }

    

    
}
