package com.bnta.backend_snack_overflow.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    @JsonIgnoreProperties({"measurements", "equipments", "users"})
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    @JsonIgnoreProperties({"measurements", "equipments", "users"})
    private Ingredient ingredient;

    @Column
    private String ingredientAmount;

    protected Measurement() {
    }

    public Measurement(Recipe recipe, Ingredient ingredient, String ingredientAmount) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.ingredientAmount = ingredientAmount;
    }

    public Long getId() {
        return id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getIngredientAmount() {
        return ingredientAmount;
    }

    public void setIngredientAmount(String ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

//    @PreRemove
//    private void removeMeasurementFromRecipeAndIngredient() {
//        recipe.getMeasurements().remove(this);
//        ingredient.getMeasurements().remove(this);
//    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
//                ", recipe=" + recipe +
//                ", ingredient=" + ingredient +
                ", ingredientAmount='" + ingredientAmount + '\'' +
                '}';
    }
}
