package com.bnta.backend_snack_overflow.repositories;

import com.bnta.backend_snack_overflow.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

   // http://localhost:8084/recipes?name=Tacos
    List<Recipe> findRecipeByNameIsContainingIgnoreCase(String name);
}

