package com.example.demo.Application.PizzaApplication;

import com.example.demo.Application.CommentApplication.CommentDTO;
import com.example.demo.Application.CommentApplication.CreateDTOComment;
import com.example.demo.Application.IngredientApplication.IngredientApplicationImp;
import com.example.demo.Domain.IngredientDomain.Ingredient;
import com.example.demo.Domain.IngredientDomain.IngredientRepositoryRead;
import com.example.demo.Domain.IngredientDomain.IngredientRepositoryWrite;
import com.example.demo.Domain.PizzaDomain.Pizza;
import com.example.demo.Domain.PizzaDomain.PizzaProjection;
import com.example.demo.Domain.PizzaDomain.PizzaRepositoryRead;
import com.example.demo.Domain.PizzaDomain.PizzaRepositoryWrite;
import com.example.demo.core.ApplicationBase;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.UUID;

@Service
public class PizzaApplicationImp extends ApplicationBase<Pizza, UUID> implements PizzaApplication {


    private final PizzaRepositoryWrite pizzaRepositoryWrite;
    private final PizzaRepositoryRead pizzaRepositoryRead;
    private final IngredientRepositoryWrite ingredientRepositoryWrite;
    private final IngredientRepositoryRead ingredientRepositoryRead;
    private final IngredientApplicationImp ingredientApplicationImp;
    private final ModelMapper modelMapper;
    private final Logger logger;

    @Autowired
    public PizzaApplicationImp(final PizzaRepositoryWrite pizzaRepositoryWrite, final PizzaRepositoryRead pizzaRepositoryRead, final IngredientRepositoryWrite ingredientRepositoryWrite, final IngredientRepositoryRead ingredientRepositoryRead, final ModelMapper modelMapper, final Logger logger, final IngredientApplicationImp ingredientApplicationImp) {
        super((id) -> pizzaRepositoryWrite.findById(id));
        this.pizzaRepositoryWrite = pizzaRepositoryWrite;
        this.pizzaRepositoryRead = pizzaRepositoryRead;
        this.ingredientRepositoryWrite = ingredientRepositoryWrite;
        this.ingredientRepositoryRead = ingredientRepositoryRead;
        this.modelMapper = modelMapper;
        this.logger = logger;
        this.ingredientApplicationImp = ingredientApplicationImp;
    }

    @Override
    public PizzaDTO add(CreateOrUpdatePizzaDTO dto) {
        Pizza pizza = this.modelMapper.map(dto, Pizza.class);
        pizza.setId(UUID.randomUUID());
        for (UUID ingredientId : dto.getIngredients()) {
            Ingredient ingredient = this.modelMapper.map(ingredientApplicationImp.get(ingredientId), Ingredient.class);
            pizza.addIngredient(ingredient);
        }
        pizza.setPrice(pizza.calculatePrice());
        pizza.validate("name", pizza.getName(), (name) -> this.pizzaRepositoryWrite.exists(name));
        this.pizzaRepositoryWrite.add(pizza);
        logger.info(this.serializeObject(pizza, " added."));
        return this.modelMapper.map(pizza, PizzaDTO.class);
    }

    @Override
    public PizzaDTO get(UUID id) {
        Pizza pizza = this.findById(id);
        return this.modelMapper.map(pizza, PizzaDTO.class);
    }

    @Override
    public List<PizzaProjection> getAll(String name, int page, int size) {
        return this.pizzaRepositoryRead.getAll(name, page, size);
    }

    @Override
    public PizzaDTO update(UUID id, CreateOrUpdatePizzaDTO dto) {
        Pizza pizza = this.findById(id);
        pizza.setId(id);
        if(this.pizzaRepositoryWrite.exists(pizza.getName())) {
            pizza.validate();
        } else {
            pizza.validate("name", pizza.getName(), (name)-> this.pizzaRepositoryWrite.exists(name));
        }
        pizza.setName(dto.getName());
        this.pizzaRepositoryWrite.update(pizza);
        logger.info(this.serializeObject(pizza, " updated"));
        return this.modelMapper.map(pizza, PizzaDTO.class);
    }

    @Override
    public void delete(UUID id) {
        Pizza pizza = this.findById(id);
        this.pizzaRepositoryWrite.delete(pizza);
        logger.info(this.serializeObject(pizza, " deleted"));
    }

    public String serializeObject(Pizza pizza, String message){
        return String.format("Pizza {id: %s, name: %s, price: %s} %s succesfully.",
                pizza.getId(), pizza.getName(),
                pizza.getPrice().toString(),
                message);
    }
}
