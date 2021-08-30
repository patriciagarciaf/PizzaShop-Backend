package com.example.demo.Infraestructure.PizzaInfraestructure;

import com.example.demo.Domain.PizzaDomain.Pizza;
import com.example.demo.Domain.PizzaDomain.PizzaProjection;
import com.example.demo.Domain.PizzaDomain.PizzaRepositoryRead;
import com.example.demo.Domain.PizzaDomain.PizzaRepositoryWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PizzaRepositoryImp implements PizzaRepositoryWrite, PizzaRepositoryRead {

    private final PizzaJPARepository pizzaJPARepository;

    @Autowired
    public PizzaRepositoryImp(final PizzaJPARepository pizzaJPARepository) {
        this.pizzaJPARepository = pizzaJPARepository;
    }

    @Override
    public void add(Pizza pizza) {
        this.pizzaJPARepository.save(pizza);
    }

    @Override
    public Optional<Pizza> findById(UUID id) {
        return this.pizzaJPARepository.findById(id);
    }

    @Override
    public void update(Pizza pizza) {
        this.pizzaJPARepository.save(pizza);
    }

    @Override
    public void delete(Pizza pizza) {
        this.pizzaJPARepository.delete(pizza);
    }

    @Override
    public List<PizzaProjection> getAll(String name, int page, int size) {
        return this.pizzaJPARepository.findByCriteria(
                name,
                PageRequest.of(page, size, Sort.by("name").descending())
        );
    }
    @Override
    public boolean exists(String name) {
        return this.pizzaJPARepository.exists(name);
    }
}
