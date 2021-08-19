package com.example.demo.Domain.PizzaDomain;

import java.math.BigDecimal;
import java.util.UUID;

//@Projection(name="pizzaProjection", types={Pizza.c})

public interface PizzaProjection {

    UUID getId();

    String getName();

    String getDescription();

    public BigDecimal getPrice();

    //TODO: imagen

    
}
