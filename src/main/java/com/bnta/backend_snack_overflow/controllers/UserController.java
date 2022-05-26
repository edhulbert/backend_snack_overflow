package com.bnta.backend_snack_overflow.controllers;

import com.bnta.backend_snack_overflow.models.Ingredient;
import com.bnta.backend_snack_overflow.models.Recipe;
import com.bnta.backend_snack_overflow.models.User;
import com.bnta.backend_snack_overflow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {
        var user = userRepository.findById(id);
        return new ResponseEntity<>(user, user.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/{id}/cupboard")
    public ResponseEntity<List<Ingredient>> getUserCupboard(@PathVariable Long id) {
        var user = userRepository.findById(id);
        return new ResponseEntity<>(user.get().getCupboard(), user.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/{id}/cupboard/recipes")
    public ResponseEntity<List<Recipe>> getRecipesBasedOnCupboard(@PathVariable Long id) {
        return new ResponseEntity<>(userRepository.findRecipeByCupboardAndId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/fave-recipes")
    public ResponseEntity<List<Recipe>> getUserFaveRecipes(@PathVariable Long id) {
        var user = userRepository.findById(id);
        return new ResponseEntity<>(user.get().getFaveRecipes(), user.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);

    }
    //CREATE
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userUpdate) {
        var user = userRepository.findById(id);

        if (user.isPresent()) {
            User _user = user.get();
            _user.setUsername(userUpdate.getUsername());
            _user.setPassword(userUpdate.getPassword());
            _user.setCupboard(userUpdate.getCupboard());
            _user.setFaveRecipes(userUpdate.getFaveRecipes());
            userRepository.save(_user);
            return new ResponseEntity<>(_user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deleteUser (@PathVariable Long id) {

        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
