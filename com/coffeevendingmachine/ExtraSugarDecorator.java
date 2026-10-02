package com.coffeevendingmachine;
import java.util.*;

public class ExtraSugarDecorator extends CoffeeDecorator{

    public int extraCost=10;
    public Map<Ingredient, Integer> extraAddition;
    {
        Map<Ingredient, Integer> map = new HashMap<>();
        map.put(Ingredient.SUGAR, 10);
        extraAddition = map;
    }

    public ExtraSugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public void prepare(){
        super.prepare();
        System.out.println("Adding extra sugar");
    }

    public int getPrice(){
        return decoratedCoffee.getPrice()+extraCost;
    }

    public String getCoffeeType(){
        return decoratedCoffee.getCoffeeType()+"Extra Sugar";
    }

    public Map<Ingredient,Integer> getRecipe(){
        Map<Ingredient,Integer> combined = new HashMap<>(decoratedCoffee.getRecipe());
        extraAddition.forEach((k,v)->combined.put(k,combined.getOrDefault(k,0)+v));
        return combined;
    }


}
