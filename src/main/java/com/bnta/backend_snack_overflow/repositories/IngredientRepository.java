package com.bnta.backend_snack_overflow.repositories;

import com.bnta.backend_snack_overflow.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
