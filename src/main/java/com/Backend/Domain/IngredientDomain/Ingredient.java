package com.Backend.Domain.IngredientDomain;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;


@Entity
public class Ingredient {
    @Id
    @Type(type = "uuid-char")
    public UUID id;

    @Column(nullable = false) //Hace que no se realice ninguna validación a la base de datos
    public String name;

    @Column(nullable = false) //Hace que no se realice ninguna validación a la base de datos
    public Float price;

}