package com.Backend.Application.CommentApplication;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class PizzaDTO {

    public UUID id;
    public String name;
    public String description;
    public BigDecimal price;
    public Set<PizzaIngredientDTO> ingredients= new HashSet<PizzaIngredientDTO>();
    
}
