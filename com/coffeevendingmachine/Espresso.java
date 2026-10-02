package com.coffeevendingmachine;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Espresso extends Coffee{

    public Espresso(){
        this.coffeeType="Espresso";
    }

    @Override
    public void addCondiments() {
        System.out.println("Espresso served pure (no milk).");
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        Map<Ingredient,Integer> recipe = new HashMap<>();
        recipe.put(Ingredient.COFFEE_BEANS,18);
        recipe.put(Ingredient.WATER,50);
        return recipe;
    }

    @Override
    public int getPrice() {
        return 100;
    }
}
