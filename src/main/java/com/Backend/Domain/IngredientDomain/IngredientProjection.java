package com.Backend.Domain.IngredientDomain;

import java.util.UUID;

public interface IngredientProjection {

    UUID getId();

    String getName();

    public Float getPrice();

}
