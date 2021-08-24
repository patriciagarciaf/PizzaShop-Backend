package com.example.demo.Controller;

import java.util.UUID;

import com.example.demo.Application.IngredientApplication.CreateOrUpdateIngredientDTO;
import com.example.demo.Application.IngredientApplication.IngredientApplication;
import com.example.demo.Application.IngredientApplication.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/ingredients")
public class IngredientController {

    private final IngredientApplication ingredientApplication;

    @Autowired
    IngredientController(final IngredientApplication ingredientApplication) {
        this.ingredientApplication = ingredientApplication;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestBody final CreateOrUpdateIngredientDTO dto) {
        IngredientDTO ingredientDTO = this.ingredientApplication.add(dto);
        return ResponseEntity.status(201).body(ingredientDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody CreateOrUpdateIngredientDTO dto) {
        this.ingredientApplication.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,  path = "/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id) {
        IngredientDTO ingredientDTO = this.ingredientApplication.get(id);
        return ResponseEntity.ok(ingredientDTO);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable UUID id) {
        this.ingredientApplication.delete(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(
        @RequestParam(required = false) String name,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ){
        return ResponseEntity.status(200).body(this.ingredientApplication.getAll(name, page, size));
    }
}