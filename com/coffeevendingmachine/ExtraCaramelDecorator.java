package com.coffeevendingmachine;

import java.util.HashMap;
import java.util.Map;

public class ExtraCaramelDecorator extends CoffeeDecorator{

    public int extraCost=20;
    public Map<Ingredient, Integer> extraAddition;
    {
        Map<Ingredient, Integer> map = new HashMap<>();
        map.put(Ingredient.CARAMEL_SYRUP, 20);
        extraAddition = map;
    }

    public ExtraCaramelDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public void prepare(){
        super.prepare();
        System.out.println("Adding extra caramel");
    }

    public int getPrice(){
        return decoratedCoffee.getPrice()+extraCost;
    }

    public Map<Ingredient,Integer> getRecipe(){
        Map<Ingredient,Integer> combinedMap = new HashMap<>(decoratedCoffee.getRecipe());
        extraAddition.forEach((k,v)-> combinedMap.put(k, combinedMap.getOrDefault(k,0)+v)) ;
        return combinedMap;
    }

    public String getCoffeeType(){
        return decoratedCoffee.getCoffeeType()+"Extra Caramel";
    }


}
