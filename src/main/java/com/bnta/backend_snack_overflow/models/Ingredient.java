package com.bnta.backend_snack_overflow.models;

import java.util.ArrayList;
import java.util.List;

public class Ingredient {
    private Long id;
    private String name;
    private List<Measurement> measurements;

    protected Ingredient () {}

    public Ingredient(String name) {
        this.name = name;
        this.measurements = new ArrayList<>();
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

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measurements=" + measurements +
                '}';
    }
}
