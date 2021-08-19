package com.example.demo.Application.PizzaApplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.Application.CommentApplication.CommentDTO;
import com.example.demo.Application.CommentApplication.CreateDTOComment;
import com.example.demo.Domain.PizzaDomain.PizzaIngredientProjection;
import com.example.demo.Domain.PizzaDomain.PizzaProjection;

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
