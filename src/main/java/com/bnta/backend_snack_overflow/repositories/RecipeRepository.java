package com.bnta.backend_snack_overflow.repositories;

import com.bnta.backend_snack_overflow.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
