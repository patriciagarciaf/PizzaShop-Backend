package com.example.demo.Application.IngredientApplication;

import java.util.*;

import com.example.demo.Domain.IngredientDomain.IngredientProjection;

public interface IngredientApplication {

    public IngredientDTO add(CreateOrUpdateIngredientDTO dto);
    public IngredientDTO get(UUID id);

    public IngredientDTO update(UUID id, CreateOrUpdateIngredientDTO dtos);
    public void delete(UUID id);

    public List<IngredientProjection> getAll(String name,  int page, int size);
}