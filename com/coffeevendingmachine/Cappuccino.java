package com.coffeevendingmachine;
import java.util.*;
import java.util.Collections;
import java.util.Map;

public class Cappuccino extends Coffee{

    public Cappuccino() {
        this.coffeeType = "Cappuccino";
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        Map<Ingredient, Integer> recipe = new HashMap<>();
        recipe.put(Ingredient.WATER, 50);
        recipe.put(Ingredient.COFFEE_BEANS, 18);
        recipe.put(Ingredient.MILK, 100);
        return recipe;
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding equal parts steamed milk and dense milk foam.");
    }

    @Override
    public int getPrice() {
        return 140;
    }
}
