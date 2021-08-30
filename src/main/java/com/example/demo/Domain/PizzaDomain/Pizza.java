package com.example.demo.Domain.PizzaDomain;

import com.example.demo.Domain.IngredientDomain.Ingredient;
import com.example.demo.core.EntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
import java.awt.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public @NoArgsConstructor @Getter @Setter
class Pizza extends EntityBase {
    @Id
    @Type(type = "uuid-char")
    public UUID id;

    @Column(nullable = false)
    public String name;

    private BigDecimal price;

    @Column
    public String description;

    //@Embedded
    //public Image image;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
    public BigDecimal calculatePrice() {
        BigDecimal total = new BigDecimal(0.0);
        BigDecimal addPrice = new BigDecimal(1.2);
        for (Ingredient ingredient : this.ingredients) {
            total = total.add(ingredient.price);
        }
        total = total.multiply(addPrice);
        return total;
    }
   @ManyToMany
   Set<Ingredient> ingredients = new HashSet<Ingredient>();

   //@OneToMany(cascade = CascadeType.ALL)
   //@JoinColumn(name = "pizza_id")
   //Set<Comment> comments = new HashSet<Comment>();
}
