package com.bnta.backend_snack_overflow.repositories;

import com.bnta.backend_snack_overflow.models.Recipe;
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

    @Query(value = "SELECT * FROM recipes INNER JOIN measurements ON recipes.id = measurements.recipe_id INNER JOIN ingredients " +
            "ON measurements.ingredient_id = ingredients.id WHERE ingredients.name ILIKE CONCAT('%',?1,'%') ORDER BY (prep_time + cook_time)",
            nativeQuery = true)
    List<Recipe> findByIngredientAndSortByTotalTime(String ingredient);

    @Query(value = "SELECT DISTINCT recipes.* FROM recipes INNER JOIN measurements ON recipes.id = measurements.recipe_id " +
            "INNER JOIN ingredients ON measurements.ingredient_id = ingredients.id WHERE recipes.id NOT IN " +
            "( SELECT recipes.id FROM recipes INNER JOIN measurements ON recipes.id = measurements.recipe_id " +
            "INNER JOIN ingredients ON measurements.ingredient_id = ingredients.id WHERE ingredients.name ILIKE ?1)", nativeQuery = true)
    List<Recipe> findByIngredientsNotIncluding(String dietaryRestriction);

    List<Recipe> findRecipeByMeasurements_Ingredient_NameInIgnoreCase(List<String> ingredients);
}

