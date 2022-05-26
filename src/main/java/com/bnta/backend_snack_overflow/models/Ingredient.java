package com.bnta.backend_snack_overflow.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "ingredient", orphanRemoval = true)
    @JsonIgnoreProperties({"ingredient", "equipments"})
    private List<Measurement> measurements;

    @ManyToMany(mappedBy = "cupboard")
    @JsonIgnoreProperties({"ingredients", "users", "cupboard", "faveRecipes"})
    //@JsonIgnoreProperties({"ingredients, users, measurements"})
    private List<User> users;

    protected Ingredient() {
    }

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @PreRemove
    private void removeIngredientFromUser() {
        for (User user:users ){
            user.getCupboard().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", measurements=" + measurements +
                '}';
    }
}
