package com.example.demo.Domain.PizzaDomain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

public interface PizzaIngredientProjection{

    public UUID getId();

    public String getName();

    public BigDecimal getPrice();

    public String getDescription();

    public Set<Ingredient> getIngredients();

    public Set<Comment> getComments();

    //TODO: imagen

    public interface Ingredient {
        public UUID getId();
        public String getName();
        
    }

    public interface Comment {
        public UUID getId();
        public String getText();
        public int getScore();
        public Date getDate();
    }

}