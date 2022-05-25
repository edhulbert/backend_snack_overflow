package com.bnta.backend_snack_overflow;

import com.bnta.backend_snack_overflow.repositories.IngredientRepository;
import com.bnta.backend_snack_overflow.repositories.RecipeRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		assertThat(recipeRepository.findRecipeByMeasurements_Ingredient_NameIgnoreCase("Egg").size()).isEqualTo(4);
	}

	@Test
	public void canOrderByPrepTimeAndCookTime (){
		assertThat(recipeRepository.findByOrderByPrepTimeAndCookTime().get(6)).isEqualTo(recipeRepository.findById(3L).get());
	}

	@Test
	public void canOrderByPrepTime() {
		assertThat(recipeRepository.findByOrderByPrepTimeAscIdAsc().get(0)).isEqualTo(recipeRepository.findById(1L).get());
	}

	@Test
	public void canOrderByCookTime() {
		assertThat(recipeRepository.findByOrderByCookTimeAscIdAsc().get(0)).isEqualTo(recipeRepository.findById(1L).get());
	}


}
