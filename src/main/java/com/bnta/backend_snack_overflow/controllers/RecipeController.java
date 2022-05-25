package com.bnta.backend_snack_overflow.controllers;

import com.bnta.backend_snack_overflow.models.Recipe;
import com.bnta.backend_snack_overflow.repositories.MeasurementRepository;
import com.bnta.backend_snack_overflow.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private MeasurementRepository measurementRepository;

    //INDEX
    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipesAndFilters(@RequestParam(required = false, name = "recipe-name") String recipeName,
                                                                @RequestParam(required = false, name = "ingredient") String ingredientName,
                                                                @RequestParam(required = false, name = "sort-by-total-time") Boolean sortByTotalTime,
                                                                @RequestParam(required = false, name = "dietary-restriction") String dietaryRestriction,
                                                                @RequestParam(required = false, name = "ingredients") List<String> ingredientList) {

        if (ingredientName != null && sortByTotalTime != null) {
            return new ResponseEntity<>(recipeRepository.findByIngredientAndSortByTotalTime(ingredientName), HttpStatus.OK);
        } else if (recipeName != null) {
            return new ResponseEntity<>(recipeRepository.findRecipeByNameIsContainingIgnoreCase(recipeName), HttpStatus.OK);
        } else if (ingredientName != null) {
            return new ResponseEntity<>(recipeRepository.findRecipeByMeasurements_Ingredient_NameIgnoreCase(ingredientName), HttpStatus.OK);
        } else if (sortByTotalTime != null) {
            if (sortByTotalTime == true)
                return new ResponseEntity<>(recipeRepository.findByOrderByPrepTimeAndCookTime(), HttpStatus.OK);
        } else if (dietaryRestriction != null) {
            return new ResponseEntity<>(recipeRepository.findByIngredientsNotIncluding(dietaryRestriction), HttpStatus.OK);
        } else if (ingredientList != null) {
            return new ResponseEntity<>(recipeRepository.findRecipeByMeasurements_Ingredient_NameInIgnoreCase(ingredientList), HttpStatus.OK);
        }


        return new ResponseEntity<>(recipeRepository.findAll(), HttpStatus.OK);
    }


    //SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Recipe>> getRecipe(@PathVariable Long id) {
        var recipe = recipeRepository.findById(id);
        return new ResponseEntity<>(recipe, recipe.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    //CREATE
    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        recipeRepository.save(recipe);
        return new ResponseEntity<>(recipe, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipeUpdate) {
        var recipe = recipeRepository.findById(id);

        if (recipe.isPresent()) {
            Recipe _recipe = recipe.get();
            _recipe.setName(recipeUpdate.getName());
            _recipe.setPrepTime(recipeUpdate.getPrepTime());
            _recipe.setCookTime(recipeUpdate.getCookTime());
            _recipe.setPortionSize(recipeUpdate.getPortionSize());
            _recipe.setCuisine(recipeUpdate.getCuisine());
            _recipe.setEquipments(recipeUpdate.getEquipments());
            recipeRepository.save(_recipe);
            return new ResponseEntity<>(_recipe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable Long id) {

        try {

            recipeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
