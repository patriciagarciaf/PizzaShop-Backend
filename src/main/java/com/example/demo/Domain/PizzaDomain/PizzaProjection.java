package com.example.demo.Domain.PizzaDomain;

import java.math.BigDecimal;
import java.util.UUID;

public interface PizzaProjection {

    UUID getId();

    String getName();

    public BigDecimal getPrice();

    public Image getImage();

    public interface Image {
        public String getPublic_id();
    };

}
