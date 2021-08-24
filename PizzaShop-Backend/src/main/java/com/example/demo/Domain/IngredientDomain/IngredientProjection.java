package com.example.demo.Domain.IngredientDomain;

import java.math.BigDecimal;
import java.util.UUID;

public interface IngredientProjection {
    UUID getId();
    String getName();
    public BigDecimal getPrice();

}
