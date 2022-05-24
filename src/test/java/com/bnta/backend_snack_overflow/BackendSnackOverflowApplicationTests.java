package com.bnta.backend_snack_overflow;

import com.bnta.backend_snack_overflow.models.Recipe;
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
	@Test
	void contextLoads() {
	}

	@Test
	public void canFindRecipeByName (){
		assertThat(recipeRepository.findRecipeByName("Tacos").size()).isEqualTo(1);
	}


}
