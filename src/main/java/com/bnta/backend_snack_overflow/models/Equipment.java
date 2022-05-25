package com.bnta.backend_snack_overflow.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "equipments")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "equipments")
    @JsonIgnoreProperties({"equipments", "measurements"})
    private List<Recipe> recipes;

    protected Equipment() {
    }

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


    public void removeRecipe(Recipe recipe) {
        this.recipes.remove(recipe);
        recipe.getEquipments().remove(this);
    }

    @PreRemove
    private void removeEquipmentsFromRecipes() {
        for (Recipe recipe : recipes) {
            recipe.getEquipments().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", recipes=" + recipes +
                '}';
    }
}
