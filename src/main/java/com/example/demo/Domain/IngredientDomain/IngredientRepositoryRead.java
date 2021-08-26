package com.example.demo.Domain.IngredientDomain;

import java.util.List;

public interface IngredientRepositoryRead {
    public List<IngredientProjection> getAll(String name, int page, int size);
}
