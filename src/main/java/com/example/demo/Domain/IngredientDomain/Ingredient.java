package com.example.demo.Domain.IngredientDomain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.core.EntityBase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public @NoArgsConstructor @Getter @Setter class Ingredient extends EntityBase {

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false, unique = true) 
    public String name;

    @DecimalMin(value = "0.0", inclusive = false)
    @Column(nullable = false)
    public BigDecimal price;

}