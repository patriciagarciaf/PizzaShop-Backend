package com.example.demo.Domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.Domain.PizzaDomain.Pizza;
import com.example.demo.Domain.UserDomain.User;

import org.hibernate.annotations.Type;




@Entity
public class Comment{
    
    @Id
    @Type (type = "uuid-char")
    public UUID id;

    @NotBlank
    @Size(max=2000)
    @Column (nullable = false)
    public String text;

    @Column (nullable = false)
    public Date date;

    @Column (nullable = false)
    public int score;



    private @ManyToOne @JoinColumn(name = "user_id", insertable = false, updatable = false) User user;

    private @ManyToOne @JoinColumn(name = "pizza_id", insertable = false, updatable = false) Pizza pizza;

    
    // public Comment(String text, int score, Date date, User user, Pizza pizza){
    //     this.text = text;
    //     this.score = score;
    //     this.date = date;
    //     this.user = user;
    //     this.pizza = pizza;
    // }
}