package com.bnta.backend_snack_overflow.controllers;

import com.bnta.backend_snack_overflow.models.Recipe;
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

    //INDEX
    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
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
    public ResponseEntity<Optional<Recipe>> deleteRecipe (@PathVariable Long id) {
        //var recipe = recipeRepository.findById(id);
        recipeRepository.deleteById(id);
        //return new ResponseEntity<>(recipe, recipe.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
        return new ResponseEntity<>(recipeRepository.findById(id), HttpStatus.OK);
    }
}
