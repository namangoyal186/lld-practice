package com.coffeevendingmachine;
import java.util.*;

import java.util.Collections;
import java.util.Map;

public class Latte extends Coffee{

    public Latte() {
        this.coffeeType = "Latte";
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        Map<Ingredient, Integer> recipe = new HashMap<>();
        recipe.put(Ingredient.WATER, 50);
        recipe.put(Ingredient.COFFEE_BEANS, 18);
        recipe.put(Ingredient.MILK, 150);
        return recipe;
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding steamed milk and light foam for Latte.");
    }

    @Override
    public int getPrice() {
        return 150;
    }
}
