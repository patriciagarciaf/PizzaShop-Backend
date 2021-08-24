package com.example.demo.Domain.IngredientDomain;

import java.util.Optional;
import java.util.UUID;

// import java.util.List;


public interface IngredientRepositoryWrite {

    void add(Ingredient ingredient);
    Optional<Ingredient> findById(UUID id);
    void update(Ingredient ingredient);
    void delete(Ingredient ingredient);

}