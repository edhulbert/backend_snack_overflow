package com.bnta.backend_snack_overflow.models;

public class Measurement {
    private Long id;
    private Recipe recipe;
    private Ingredient ingredient;
    private String ingredientAmount;

    protected Measurement () {}
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

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", recipe=" + recipe +
                ", ingredient=" + ingredient +
                ", ingredientAmount='" + ingredientAmount + '\'' +
                '}';
    }
}
