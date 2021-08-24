package com.example.demo.Infraestructure.IngredientInfraestructure;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

// import java.util.List;
// import java.util.Optional;
// import java.util.UUID;

import com.example.demo.Domain.IngredientDomain.Ingredient;
import com.example.demo.Domain.IngredientDomain.IngredientProjection;
import com.example.demo.Domain.IngredientDomain.IngredientRepositoryRead;
import com.example.demo.Domain.IngredientDomain.IngredientRepositoryWrite;

//import lombok.*;
// import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

// @Slf4j
@Repository
public class IngredientRepositoryImp implements IngredientRepositoryRead, IngredientRepositoryWrite {

    private final IngredientJPARepository ingredientJPARepository; // creas una instancia del jpa repository

    @Autowired
    // constructor
    public IngredientRepositoryImp(final IngredientJPARepository ingredientJPARepository) {
        this.ingredientJPARepository = ingredientJPARepository;
    }

    @Override
    public void add(Ingredient ingredient) {
        this.ingredientJPARepository.save(ingredient);
    //    log.error("Ha ocurrido un problema al introducir una pizza");
    }

    @Override
    public void delete(Ingredient ingredient) {
        this.ingredientJPARepository.delete(ingredient);
        
    }

    @Override
    public Optional<Ingredient> findById(UUID id) {
        return this.ingredientJPARepository.findById(id);
    }

    @Override
    public List<IngredientProjection> getAll(String name, int page, int size) {
        return this.ingredientJPARepository.findByCriteria(
                name,
                PageRequest.of(page, size, Sort.by("name").descending())
        );
    }

    @Override
    public void update(Ingredient ingredient) {
        this.ingredientJPARepository.save(ingredient);
        
    }

}
