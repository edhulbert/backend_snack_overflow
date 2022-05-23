package com.bnta.backend_snack_overflow.components;

import com.bnta.backend_snack_overflow.models.*;
import com.bnta.backend_snack_overflow.repositories.EquipmentRepository;
import com.bnta.backend_snack_overflow.repositories.IngredientRepository;
import com.bnta.backend_snack_overflow.repositories.MeasurementRepository;
import com.bnta.backend_snack_overflow.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private MeasurementRepository measurementRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // new equipments
        Equipment equ1 = new Equipment("Saucepan");
        Equipment equ2 = new Equipment("Spatula");
        Equipment equ3 = new Equipment("Frying pan");
        Equipment equ4 = new Equipment("Mixing bowl");
        Equipment equ5 = new Equipment("Knife");
        Equipment equ6 = new Equipment("Whisk");
        Equipment equ7 = new Equipment("Wooden spoon");
        Equipment equ8 = new Equipment("Measuring Cup");
        Equipment equ9 = new Equipment("Scales");
        Equipment equ10 = new Equipment("Measuring spoon");
        Equipment equ11 = new Equipment("Rolling pin");
        Equipment equ12 = new Equipment("Oven");
        Equipment equ13 = new Equipment("Baking tray");
        equipmentRepository.saveAll(Arrays.asList(equ1,equ2,equ3,equ4,equ5,equ6,equ7,equ8,equ9,equ10,equ11,equ12,equ13));

        // new ingredients
        Ingredient ingredient1 = new Ingredient("Egg");
        Ingredient ingredient2 = new Ingredient("Flour");
        Ingredient ingredient3 = new Ingredient("Butter");
        Ingredient ingredient4 = new Ingredient("Milk");
        Ingredient ingredient5 = new Ingredient("Oil");
        Ingredient ingredient6 = new Ingredient("Salt");
        Ingredient ingredient7 = new Ingredient("Chicken");
        Ingredient ingredient8 = new Ingredient("Beef");
        Ingredient ingredient9 = new Ingredient("Lamb");
        Ingredient ingredient10 = new Ingredient("Water");
        Ingredient ingredient11 = new Ingredient("Rice");
        Ingredient ingredient12 = new Ingredient("Pasta");
        Ingredient ingredient13 = new Ingredient("Tinned tomatoes");
        Ingredient ingredient14 = new Ingredient("Beans");
        Ingredient ingredient15 = new Ingredient("Chilli powder");
        Ingredient ingredient16 = new Ingredient("Cheese");
        ingredientRepository.saveAll(Arrays.asList(ingredient1,ingredient2,ingredient3,ingredient4,ingredient5,ingredient6,
                ingredient7,ingredient8,ingredient9,ingredient10,ingredient11,ingredient12,ingredient13,ingredient14,ingredient15,ingredient16));


        // new recipes
        Recipe recipe1 = new Recipe("BBQ Chicken Pizza",10, 20, 1, Cuisine.ITALIAN, Arrays.asList(equ12, equ13, equ11, equ9, equ4, equ7));
        Recipe recipe2 = new Recipe("Burger",20, 10, 4, Cuisine.AMERICAN, Arrays.asList(equ2, equ3, equ4, equ9));
        Recipe recipe3 = new Recipe("Spaghetti Bolognese",30, 60, 4, Cuisine.ITALIAN, Arrays.asList(equ1, equ7, equ8, equ10, equ12));
        Recipe recipe4 = new Recipe("Tacos",30, 20, 4, Cuisine.MEXICAN, Arrays.asList(equ3, equ4, equ5, equ9, equ11, equ13));
        Recipe recipe5 = new Recipe("Tikka Masala",10, 30, 1, Cuisine.INDIAN, Arrays.asList(equ3, equ4, equ7));
        Recipe recipe6 = new Recipe("Chow Mein",20, 10, 2, Cuisine.CHINESE, Arrays.asList(equ5, equ3, equ7));
        Recipe recipe7 = new Recipe("Nigerian Jollof Rice",20, 30, 4, Cuisine.NIGERIAN, Arrays.asList(equ8, equ1, equ7, equ9));
        recipeRepository.saveAll(Arrays.asList(recipe1,recipe2,recipe3,recipe4,recipe5,recipe6,recipe7));


        // new measurements
        Measurement measurement1 = new Measurement(recipe1, ingredient1, "1");
        Measurement measurement2 = new Measurement(recipe1, ingredient2, "200g");
        Measurement measurement3 = new Measurement(recipe1, ingredient3, "50g");
        Measurement measurement4 = new Measurement(recipe1, ingredient4, "150ml");
        Measurement measurement5 = new Measurement(recipe1, ingredient6, "a pinch");
        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1 tin");
        Measurement measurement7 = new Measurement(recipe1, ingredient16, "As much as you need");
        Measurement measurement8 = new Measurement(recipe1, ingredient7, "100g");


//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");
//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");
//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");
//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");
//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");
//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");
//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");
//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");
//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");
//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");
//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");
//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");
//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");
//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");
//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");
//        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1");

        measurementRepository.saveAll(Arrays.asList(measurement1,measurement2,measurement3,measurement4,measurement5,measurement6,
                measurement7,measurement8));
    }
}
