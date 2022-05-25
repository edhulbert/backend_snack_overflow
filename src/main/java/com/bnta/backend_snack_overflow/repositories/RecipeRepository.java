package com.bnta.backend_snack_overflow.repositories;

import com.bnta.backend_snack_overflow.models.Ingredient;
import com.bnta.backend_snack_overflow.models.Recipe;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

   // http://localhost:8084/recipes?name=Tacos
    List<Recipe> findRecipeByNameIsContainingIgnoreCase(String name);

    List<Recipe> findRecipeByMeasurements_Ingredient_NameIgnoreCase(String name);

    @Query(value = "SELECT * FROM recipes ORDER BY (prep_time + cook_time)", nativeQuery = true)
    List<Recipe> findByOrderByPrepTimeAndCookTime();
    List<Recipe> findByOrderByPrepTimeAscIdAsc();
    List<Recipe> findByOrderByCookTimeAscIdAsc();

}

