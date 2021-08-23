package com.example.demo.Domain.IngredientDomain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.example.demo.core.EntityBase;


@Entity
public @NoArgsConstructor @Getter @Setter class Ingredient extends EntityBase{


    @Column (nullable = false, unique = true) //Hace que no se realice ninguna validación a la base de datos
    public String name;

    @Column (nullable = false) //Hace que no se realice ninguna validación a la base de datos
    public BigDecimal price;

}