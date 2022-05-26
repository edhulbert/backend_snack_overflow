package com.bnta.backend_snack_overflow.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column
    private Long id;

    @Column
    private String name;

    @Column
    private int prepTime;

    @Column
    private int cookTime;

    @Column
    private int portionSize;

    @Column
    private Cuisine cuisine;

    @OneToMany(mappedBy = "recipe", orphanRemoval = true)
    @JsonIgnoreProperties({"recipe"})
    private List <Measurement> measurements;

    @ManyToMany
    @JoinTable(name = "recipes_equipments",
            joinColumns = {@JoinColumn(name = "recipe_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "equipment_id", nullable = false)}
    )
    @JsonIgnoreProperties({"recipes"})
    private List <Equipment> equipments;

    @ManyToMany(mappedBy = "faveRecipes")
    @JsonIgnoreProperties({"recipes", "users", "measurements", "faveRecipes"})
    private List<User> users;

    protected Recipe (){}

    public Recipe(String name, int prepTime, int cookTime, int portionSize, Cuisine cuisine, List<Equipment> equipments) {
        this.name = name;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.portionSize = portionSize;
        this.cuisine = cuisine;
        this.measurements = new ArrayList<>();
        this.equipments = equipments;
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

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(int portionSize) {
        this.portionSize = portionSize;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @PreRemove
    private void removeRecipesFromEquipments() {
        for (Equipment equipment : equipments) {
            equipment.getRecipes().remove(this);
        }
        for (User user : users) {
            user.getFaveRecipes().remove(this);
        }

    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prepTime=" + prepTime +
                ", cookTime=" + cookTime +
                ", portionSize=" + portionSize +
                ", cuisine=" + cuisine +
//                ", measurements=" + measurements +
//                ", equipments=" + equipments +
                '}';
    }
}
