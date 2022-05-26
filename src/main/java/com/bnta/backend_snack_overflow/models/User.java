package com.bnta.backend_snack_overflow.models;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @ManyToMany
    @JoinTable(name = "users_recipes",
                joinColumns = {@JoinColumn(name = "user_id",nullable = false)},
                inverseJoinColumns = {@JoinColumn(name = "recipe_id", nullable = false)})
    @JsonIgnoreProperties({"users"})
    private List<Recipe> faveRecipes;

    @ManyToMany
    @JoinTable(name = "users_ingredients",
                joinColumns = {@JoinColumn(name = "user_id",nullable = false)},
                inverseJoinColumns = {@JoinColumn(name = "ingredient_id",nullable = false)})
    @JsonIgnoreProperties({"users", "measurements", "faveRecipes", "cupboard"})
    private List<Ingredient> cupboard;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.faveRecipes = new ArrayList<>();
        this.cupboard = new ArrayList<>();
    }

    protected User() {}

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Recipe> getFaveRecipes() {
        return faveRecipes;
    }

    public void setFaveRecipes(List<Recipe> faveRecipes) {
        this.faveRecipes = faveRecipes;
    }

    public List<Ingredient> getCupboard() {
        return cupboard;
    }

    public void setCupboard(List<Ingredient> cupboard) {
        this.cupboard = cupboard;
    }

    public void addRecipeToFavourites(Recipe recipe) {
        this.faveRecipes.add(recipe);
    }

    public void removeRecipeFromFavourites(Recipe recipe) {
        this.faveRecipes.remove(recipe);
    }

    public void addIngredientToCupboard(Ingredient ingredient) {
        this.cupboard.add(ingredient);
    }

    public void removeIngredientFromCupboard(Ingredient ingredient) {
        this.cupboard.remove(ingredient);
    }

    @PreRemove
    private void removeUsersFromRecipesAndIngredients() {
        for (Recipe recipe : faveRecipes) {
            recipe.getUsers().remove(this);
        }
        for (Ingredient ingredient : cupboard) {
            ingredient.getUsers().remove(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
//                ", faveRecipes=" + faveRecipes +
//                ", cupboard=" + cupboard +
                '}';
    }
}
