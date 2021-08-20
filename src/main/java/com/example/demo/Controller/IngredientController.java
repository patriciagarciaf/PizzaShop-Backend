package com.example.demo.Controller;

import com.example.demo.Application.IngredientApplication.CreateOrUpdateIngredientDTO;
import com.example.demo.Application.IngredientApplication.IngredientAplicattion;
import com.example.demo.Application.IngredientApplication.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/ingredients")
public class IngredientController {

    private final IngredientAplicattion ingredientAplicattion;

    @Autowired
    IngredientController(final IngredientAplicattion ingredientAplicattion) {
        this.ingredientAplicattion = ingredientAplicattion;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestBody final CreateOrUpdateIngredientDTO dto) {
        IngredientDTO ingredientDTO = this.ingredientAplicattion.add(dto);
        return ResponseEntity.status(201).body(ingredientDTO);
    }
}
