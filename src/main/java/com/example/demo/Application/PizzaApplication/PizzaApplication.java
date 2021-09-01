package com.example.demo.Application.PizzaApplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.Domain.PizzaDomain.PizzaProjection;

public interface PizzaApplication {

    public PizzaDTO add(CreateOrUpdatePizzaDTO dto);
    public PizzaDTO get(UUID id);
    public PizzaDTO update (UUID id, CreateOrUpdatePizzaDTO dto);
    public void delete (UUID id);
    public List<PizzaProjection> getAll(String name, int page, int size);
}
