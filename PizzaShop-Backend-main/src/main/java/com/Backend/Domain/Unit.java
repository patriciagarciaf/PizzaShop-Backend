package com.Backend.Domain;

import java.util.*;

import javax.persistence.Id;

import org.hibernate.annotations.Type;

public abstract class Unit{
    @Id
    @Type (type = "varchar")
    public UUID id;
}
 
