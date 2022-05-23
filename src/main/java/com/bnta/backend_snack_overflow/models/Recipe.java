package com.bnta.backend_snack_overflow.models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private Long id;
    private String name;
    private int prepTime;
    private int cookTime;
    private int portionSize;
    private Cuisine cuisine;
    private List <Measurement> measurements;
    private List <Equipment> equipments;

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

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prepTime=" + prepTime +
                ", cookTime=" + cookTime +
                ", portionSize=" + portionSize +
                ", cuisine=" + cuisine +
                ", measurements=" + measurements +
                ", equipments=" + equipments +
                '}';
    }
}
