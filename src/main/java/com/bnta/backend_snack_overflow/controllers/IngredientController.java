package com.bnta.backend_snack_overflow.controllers;

import com.bnta.backend_snack_overflow.models.Ingredient;
import com.bnta.backend_snack_overflow.models.Recipe;
import com.bnta.backend_snack_overflow.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredientAndFilters(@RequestParam(required = false, name = "name") String name) {

        if (name != null){ return new ResponseEntity<>(ingredientRepository.findIngredientsByNameIsContainingIgnoreCase(name), HttpStatus.OK);}
        return new ResponseEntity<>(ingredientRepository.findAll(), HttpStatus.OK);
    }


    //SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Ingredient>> getIngredient(@PathVariable Long id) {
        var ingredient = ingredientRepository.findById(id);
        return new ResponseEntity<>(ingredient, ingredient.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    //CREATE
    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        return new ResponseEntity<>(ingredient, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredientUpdate) {
        var ingredient = ingredientRepository.findById(id);

        if (ingredient.isPresent()) {
            Ingredient _ingredient = ingredient.get();
            _ingredient.setName(ingredientUpdate.getName());
            ingredientRepository.save(_ingredient);
            return new ResponseEntity<>(_ingredient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deleteIngredient (@PathVariable Long id) {

        try {
            ingredientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}









