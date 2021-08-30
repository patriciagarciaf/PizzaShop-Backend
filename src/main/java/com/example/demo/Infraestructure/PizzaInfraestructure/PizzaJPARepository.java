package com.example.demo.Infraestructure.PizzaInfraestructure;

import com.example.demo.Domain.IngredientDomain.Ingredient;
import com.example.demo.Domain.IngredientDomain.IngredientProjection;
import com.example.demo.Domain.PizzaDomain.Pizza;
import com.example.demo.Domain.PizzaDomain.PizzaProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PizzaJPARepository extends JpaRepository<Pizza, UUID> {

    Ingredient findByName(@Param("name") String name);

    final String sqlExists = """
                             SELECT case when count(i)> 0 then true else false
                             end from Pizza i WHERE i.name = :name
                             """;
    final String sqlCriteria = """
                               SELECT i.id as id, i.name as name, i.price as price 
                               FROM Pizza i WHERE (:name is NULL OR name LIKE %:name%)
                               """;

    @Query(sqlCriteria)
    List<PizzaProjection> findByCriteria(@Param("name") String name, Pageable pageable);

    @Query(sqlExists)
    boolean exists(@Param("name") String name);
}
