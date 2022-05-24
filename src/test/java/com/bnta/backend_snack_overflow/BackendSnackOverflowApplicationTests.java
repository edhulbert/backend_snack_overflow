package com.bnta.backend_snack_overflow;

import com.bnta.backend_snack_overflow.models.Ingredient;
import com.bnta.backend_snack_overflow.models.Recipe;
import com.bnta.backend_snack_overflow.repositories.IngredientRepository;
import com.bnta.backend_snack_overflow.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class BackendSnackOverflowApplicationTests {

@Autowired
private RecipeRepository recipeRepository;

@Autowired
private IngredientRepository ingredientRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void canFindIngredientsByName(){
		assertThat(ingredientRepository.findIngredientsByNameIsContainingIgnoreCase("B").size()).isEqualTo(4);
	}

	@Test
	public void canFindRecipeByName (){
		assertThat(recipeRepository.findRecipeByNameIsContainingIgnoreCase("Tacos").size()).isEqualTo(1);
	}

	@Test
	public void canFindRecipeByIngredient(){
		assertThat(recipeRepository.findRecipeByMeasurements_Ingredient_Name("Egg").size()).isEqualTo(4);
	}


}
