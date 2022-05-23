package com.bnta.backend_snack_overflow.models;

import java.util.ArrayList;
import java.util.List;


public class Equipment {

    private Long id;
    private String name;
    private List <Recipe> recipes;

    protected Equipment () {}

    public Equipment(String name) {


        this.name = name;
        this.recipes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
