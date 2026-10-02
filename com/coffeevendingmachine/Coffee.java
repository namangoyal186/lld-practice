package com.coffeevendingmachine;
import java.util.*;

public abstract class Coffee {

    public String coffeeType;

    public void prepare(){
        grindBeans();
        brew();
        pourIntoCup();
        addCondiments();
    }

    public void grindBeans(){
        System.out.println("Grinding fresh coffee beans");
    }

    public void brew(){
        System.out.println("Brewing coffee with hot water...");
    }

    public void pourIntoCup() {
        System.out.println("Pouring coffee into the cup...");
    }

    public abstract void addCondiments();

    public abstract Map<Ingredient,Integer> getRecipe();

    public abstract int getPrice();

    public String getCoffeeType(){
        return coffeeType;
    }


}
