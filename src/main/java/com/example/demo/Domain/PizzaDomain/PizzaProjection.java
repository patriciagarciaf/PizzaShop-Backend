package com.example.demo.Domain.PizzaDomain;

import java.math.BigDecimal;
import java.util.UUID;

public interface PizzaProjection {
    public UUID getId();

    public String getName();

    public BigDecimal getPrice();

    //public Image getImage();
}
