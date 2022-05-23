package com.bnta.backend_snack_overflow.controllers;

import com.bnta.backend_snack_overflow.models.Recipe;
import com.bnta.backend_snack_overflow.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
