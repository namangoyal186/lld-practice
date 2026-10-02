package com.coffeevendingmachine;

import java.util.Collections;
import java.util.Map;

public class CoffeeDecorator extends Coffee{
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee){
        this.decoratedCoffee=decoratedCoffee;
    }

    @Override
    public String getCoffeeType() {
        return decoratedCoffee.getCoffeeType();
    }

    @Override
    public void addCondiments() {
        decoratedCoffee.addCondiments();
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        return decoratedCoffee.getRecipe();
    }

    @Override
    public int getPrice() {
        return decoratedCoffee.getPrice();
    }

    @Override
    public void prepare(){
        decoratedCoffee.prepare();
    }


}
