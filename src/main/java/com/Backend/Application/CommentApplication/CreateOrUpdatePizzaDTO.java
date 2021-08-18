package com.Backend.Application.CommentApplication;

import java.util.HashSet;
import java.util.UUID;

public class CreateOrUpdatePizzaDTO {
    public String name;
    public HashSet<UUID> listIngredients;
    public String description;
}