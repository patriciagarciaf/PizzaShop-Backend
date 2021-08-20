package com.example.demo.Domain.IngredientDomain;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.Core.EntityBase;


@Entity
public @NoArgsConstructor @Getter @Setter class Ingredient extends EntityBase{

    // @Id
    // @Type (type = "uuid-char")
    // public UUID id;

    // public void setId(UUID id){
    //     this.id=id;
    // }

    @Column //(nullable = false) //Hace que no se realice ninguna validación a la base de datos
    public String name;

    @Column //(nullable = false) //Hace que no se realice ninguna validación a la base de datos
    public Float price;


}