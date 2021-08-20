package com.Backend.Infraestructure.IngredientInfraestructure;


import com.Backend.Domain.IngredientDomain.Ingredient;
import com.Backend.Domain.IngredientDomain.IngredientRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientRepositoryImp implements IngredientRepository {

    private final IngredientJPARepository ingredientJPARepository; // creas una instancia del jpa repository

    @Autowired
    // constructor
    public IngredientRepositoryImp(final IngredientJPARepository ingredientJPARepository) {
        this.ingredientJPARepository = ingredientJPARepository;
    }

    @Override
    public void add(Ingredient ingredient) {
        this.ingredientJPARepository.save(ingredient);
    }

}
