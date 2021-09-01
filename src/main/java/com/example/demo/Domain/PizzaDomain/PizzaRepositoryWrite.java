package com.example.demo.Domain.PizzaDomain;

import com.example.demo.Domain.IngredientDomain.Ingredient;
import com.example.demo.core.ExistsByField;
import com.example.demo.core.FindById;

import java.util.Optional;
import java.util.UUID;

public interface PizzaRepositoryWrite extends FindById<Pizza, UUID>, ExistsByField {

    public void add(Pizza pizza);

    public void update(Pizza pizza);

    public void delete(Pizza pizza);

    public Optional<Pizza> findById(UUID id);
}
