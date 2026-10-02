package com.coffeevendingmachine;
import java.util.*;

public class Inventory {
    private static Inventory inventoryInstance;
    private Map<Ingredient,Integer> stock = new EnumMap<>(Ingredient.class);

    private Inventory(){
        stock.put(Ingredient.WATER,1000);
        stock.put(Ingredient.MILK,5000);
        stock.put(Ingredient.COFFEE_BEANS,500);
        stock.put(Ingredient.SUGAR,200);
        stock.put(Ingredient.CARAMEL_SYRUP,200);
    }

    public static synchronized Inventory getInstance(){
        if(inventoryInstance==null){
            synchronized (Inventory.class){
                if(inventoryInstance==null){
                    inventoryInstance=new Inventory();
                }
            }
        }
        return inventoryInstance;
    }

    public synchronized void addStock(Ingredient ingredient, int quantity){
        stock.put(ingredient, stock.getOrDefault(ingredient,0)+quantity);
    }

    public synchronized void deductIngredients(Map<Ingredient,Integer> recipe){
        for(Map.Entry<Ingredient,Integer> mp:recipe.entrySet()){
            stock.put(mp.getKey(),stock.get(mp.getKey())-mp.getValue());
        }
    }

    public synchronized void printInventory() {
        System.out.println("--- Current Inventory Stock ---");
        stock.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("-------------------------------");
    }

    public synchronized boolean hasIngredients(Map<Ingredient,Integer> recipe){
        for(Map.Entry<Ingredient,Integer> entry: recipe.entrySet()){
            if(stock.getOrDefault(entry.getKey(),0)<entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
