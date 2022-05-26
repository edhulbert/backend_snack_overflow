package com.bnta.backend_snack_overflow.components;

import com.bnta.backend_snack_overflow.models.*;
import com.bnta.backend_snack_overflow.repositories.*;
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

    @Autowired
    private UserRepository userRepository;

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
        Ingredient ingredient2 = new Ingredient("Rice Flour");
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
        Ingredient ingredient17 = new Ingredient("Noodles");
        ingredientRepository.saveAll(Arrays.asList(ingredient1,ingredient2,ingredient3,ingredient4,ingredient5,ingredient6,
                ingredient7,ingredient8,ingredient9,ingredient10,ingredient11,ingredient12,ingredient13,ingredient14,ingredient15,ingredient16, ingredient17));


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
        //PIZZA
        Measurement measurement1 = new Measurement(recipe1, ingredient1, "1");
        Measurement measurement2 = new Measurement(recipe1, ingredient2, "200g");
        Measurement measurement3 = new Measurement(recipe1, ingredient3, "50g");
        Measurement measurement4 = new Measurement(recipe1, ingredient4, "150ml");
        Measurement measurement5 = new Measurement(recipe1, ingredient6, "a pinch");
        Measurement measurement6 = new Measurement(recipe1, ingredient13, "1 tin");
        Measurement measurement7 = new Measurement(recipe1, ingredient16, "As much as you need");
        Measurement measurement8 = new Measurement(recipe1, ingredient7, "100g");

        //BURGER
        Measurement measurement9 = new Measurement(recipe2, ingredient1, "1");
        Measurement measurement10 = new Measurement(recipe2, ingredient2, "100g");
        Measurement measurement11 = new Measurement(recipe2, ingredient3, "30g");
        Measurement measurement12 = new Measurement(recipe2, ingredient4, "90ml");
        Measurement measurement13 = new Measurement(recipe2, ingredient6, "a pinch");
        Measurement measurement14 = new Measurement(recipe2, ingredient8, "50g");
        Measurement measurement15 = new Measurement(recipe2, ingredient16, "2 slices");

        //SPAGHETTI BOLOGNESE
        Measurement measurement16 = new Measurement(recipe3, ingredient12, "120");
        Measurement measurement17 = new Measurement(recipe3, ingredient13, "2 tins");
        Measurement measurement18 = new Measurement(recipe3, ingredient8, "210g");
        Measurement measurement19 = new Measurement(recipe3, ingredient6, "A table spoon");
        Measurement measurement20 = new Measurement(recipe3, ingredient16, "As much as you want");

        //TACOS
        Measurement measurement21 = new Measurement(recipe4, ingredient2, "500g");
        Measurement measurement22 = new Measurement(recipe4, ingredient10, "500ml");
        Measurement measurement23 = new Measurement(recipe4, ingredient7, "1kg");
        Measurement measurement24 = new Measurement(recipe4, ingredient13, "1 tin");
        Measurement measurement25 = new Measurement(recipe4, ingredient14, "1 tin");
        Measurement measurement26 = new Measurement(recipe4, ingredient15, "1 tsp");
        Measurement measurement27 = new Measurement(recipe4, ingredient16, "300g");

        //JOLLOF
        Measurement measurement28 = new Measurement(recipe7, ingredient11, "300g");
        Measurement measurement29 = new Measurement(recipe7, ingredient5, "30ml");
        Measurement measurement30 = new Measurement(recipe7, ingredient10, "500ml");
        Measurement measurement31 = new Measurement(recipe7, ingredient6, "a pinch");
        Measurement measurement32 = new Measurement(recipe7, ingredient13, "1 tin");

        //TIKA MASALA
        Measurement measurement33 = new Measurement(recipe5, ingredient1, "50ml");
        Measurement measurement34 = new Measurement(recipe5, ingredient5, "3 tablespoons");
        Measurement measurement35 = new Measurement(recipe5, ingredient6, "a pinch");
        Measurement measurement36 = new Measurement(recipe5, ingredient13, "1 tin");
        Measurement measurement37 = new Measurement(recipe5, ingredient15, "As much as you need");
        Measurement measurement38 = new Measurement(recipe5, ingredient7, "200g");
        Measurement measurement39 = new Measurement(recipe5, ingredient10, "100ml");

        //CHOW MEIN
        Measurement measurement40 = new Measurement(recipe6, ingredient1, "3");
        Measurement measurement41 = new Measurement(recipe6, ingredient3, "50g");
        Measurement measurement42 = new Measurement(recipe6, ingredient6, "a pinch");
        Measurement measurement43 = new Measurement(recipe6, ingredient13, "1/2 tin");
        Measurement measurement44 = new Measurement(recipe6, ingredient16, "a pinch");
        Measurement measurement45 = new Measurement(recipe6, ingredient7, "150g");
        Measurement measurement46 = new Measurement(recipe6, ingredient17, "250g");

        measurementRepository.saveAll(Arrays.asList(measurement1,measurement2,measurement3,measurement4,measurement5,measurement6,
                measurement7,measurement8, measurement9, measurement10, measurement11, measurement12, measurement13, measurement14,
                measurement15, measurement16, measurement17, measurement18, measurement19, measurement20, measurement21, measurement22,
                measurement23, measurement24, measurement25, measurement26, measurement27, measurement28, measurement29, measurement30,
                measurement32, measurement33, measurement34, measurement35, measurement36, measurement37, measurement38,
                measurement39, measurement40, measurement41, measurement42, measurement43, measurement44, measurement45, measurement46));

        User user1 = new User("mattyp","123");
        user1.addRecipeToFavourites(recipe6);
        user1.addRecipeToFavourites(recipe4);
        user1.addIngredientToCupboard(ingredient1);
        user1.addIngredientToCupboard(ingredient6);
        user1.addIngredientToCupboard(ingredient14);
        userRepository.save(user1);
    }
}
