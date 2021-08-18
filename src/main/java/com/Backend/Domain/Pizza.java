package com.Backend.Domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
public class Pizza{

    @Id
    @Type (type = "uuid-char")
    public UUID id;

    @Column(nullable=false, unique = true)
    public String name;

    @Column
    public String description;

    @Column(nullable=false)
    public BigDecimal price;

    public void addIngredient (Ingredient ingredient){
        this.listIngredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient){
        this.listIngredients.remove(ingredient);
    }

    public void addComment (Comment comment){
        this.listComments.add(comment);
    }

    public void removeComment(Comment comment){
        this.listComments.add(comment);
    }


    public BigDecimal calculatePrice(){ //PROBAR
        float sumIngredientPrice=0.0f;
        float profit=1.2f;
        for(Ingredient ingredient: this.listIngredients){
            sumIngredientPrice+=ingredient.price;
        } 
        BigDecimal total=new BigDecimal(sumIngredientPrice*profit).setScale(2,4);
        return total;
    }     
    public void setPrice(){ 
        this.price=this.calculatePrice();
    } 

    @ManyToMany
    public Set<Ingredient> listIngredients= new HashSet<Ingredient>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pizza_id") //NOMBRE DE LA COLUMNA EN TABLA COMENTARIOS
    public Set<Comment> listComments= new HashSet<Comment>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pizza_id")
    public Set<User> listUsers= new HashSet<User>();


    

        /*TO DO:
    @Embedded
    public Image image;
    */


}