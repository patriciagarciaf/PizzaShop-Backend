package com.example.demo.Application.IngredientApplication;

import java.util.UUID;

import com.example.demo.Domain.IngredientDomain.IngredientProjection;

import java.util.List;

public interface IngredientApplication {

    public IngredientDTO add(CreateOrUpdateIngredientDTO dto);

    public void update(UUID id, CreateOrUpdateIngredientDTO dtos);

    public void delete(UUID id);

    public IngredientDTO get(UUID id);

    public List<IngredientProjection> getAll(String name,  int page, int size);

}
