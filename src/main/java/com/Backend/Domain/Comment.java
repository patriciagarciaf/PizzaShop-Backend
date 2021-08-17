package com.Backend.Domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;




@Entity
public class Comment{

    @Id
    @Type (type = "uuid-char")
    public UUID id;

    @Column (nullable = false)
    public String text;

    @Column (nullable = false)
    public Date date;

    @Column (nullable = false)
    public Double score;



    /*
    Placeholder for user implementation
    TODO: add user id
    TODO: add pizza id
    */
}