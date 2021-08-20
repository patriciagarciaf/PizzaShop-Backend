package com.Backend.Infraestructure.IngredientInfraestructure;

import java.util.List;
import java.util.UUID;

import com.Backend.Domain.IngredientDomain.Ingredient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IngredientJPARepository extends JpaRepository<Ingredient, UUID> {
 //   @Query("SELECT i.id as id, i.name as name, i.price as price FROM Ingredient i WHERE (:name is NULL OR name LIKE %:name%)")
 //   List<IngredientProjection> findByCriteria(
 //           @Param("name") String name,
 //           Pageable pageable
 //   );
}
