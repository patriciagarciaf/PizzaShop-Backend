package com.Backend.Domain.IngredientDomain;

import com.Backend.Core.EntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;


public @NoArgsConstructor @Getter @Setter class Ingredient extends EntityBase {


    @Column(nullable = false) //Hace que no se realice ninguna validación a la base de datos
    private String name;

    @Column(nullable = false) //Hace que no se realice ninguna validación a la base de datos
    private Float price;

}