package com.Backend.Application.CommentApplication;

import java.util.List;
import java.util.UUID;
import com.Backend.Domain.PizzaIngredientProjection;
import com.Backend.Domain.PizzaProjection;

public interface PizzaApplication {
    public PizzaDTO add(CreateOrUpdatePizzaDTO dto);

    public PizzaDTO get(UUID id);

    public void update(UUID id, CreateOrUpdatePizzaDTO dto);

    public void delete(UUID id);

    public CommentDTO addComment(UUID pizzaId, CreateDTOComment createCommentDTO);

    public void removeIngredient(UUID id, UUID ingredientId);

    public PizzaDTO addIngredient(UUID id, UUID ingredientId);

    public List<PizzaProjection> getAll(String name, int page, int size);

    public PizzaIngredientProjection getPizzaInfo(UUID id);

}
