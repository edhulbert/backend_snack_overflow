package com.bnta.backend_snack_overflow.models;

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
    private List<Recipe> faveRecipes;

    @ManyToMany
    @JoinTable(name = "user_cupboard",
                joinColumns = {@JoinColumn(name = "user_id",nullable = false)},
                inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    private List<Ingredient> cupboard;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.faveRecipes = new ArrayList<>();
        this.cupboard = new ArrayList<>();
    }

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
