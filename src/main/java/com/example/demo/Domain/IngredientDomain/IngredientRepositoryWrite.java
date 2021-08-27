package com.example.demo.Domain.IngredientDomain;

import java.util.UUID;

import com.example.demo.core.ExistsByField;
import com.example.demo.core.FindById;




public interface IngredientRepositoryWrite extends FindById<Ingredient, UUID>, ExistsByField {
    public void add(Ingredient ingredient);
    public void update(Ingredient ingredient);
    public void delete(Ingredient ingredient);
}
