package com.Backend;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Comment extends Entidad{

    @Column (nullable = false)
    public String text;

    @Column (nullable = false)
    public Date date;

    @Column (nullable = false)
    public Double score;

    /*
    Placeholder for user implementation
    */
}