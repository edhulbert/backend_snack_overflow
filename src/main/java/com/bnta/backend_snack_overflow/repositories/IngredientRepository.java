package com.bnta.backend_snack_overflow.repositories;

import com.bnta.backend_snack_overflow.models.Ingredient;
import com.bnta.backend_snack_overflow.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findIngredientsByNameIsContainingIgnoreCase(String name);

}


