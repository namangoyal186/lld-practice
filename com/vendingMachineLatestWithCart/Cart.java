package com.vendingMachineLatestWithCart;
import java.util.*;
public class Cart {
    Map<Item,Integer> items = new HashMap<>();

    public void addItem(Item item, int quantity){
        items.put(item,items.getOrDefault(item,0)+quantity);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public Map<Item,Integer> getItems(){
        return items;
    }

    public double calculateTotal(){
        double total=0.0;
        for(Map.Entry<Item,Integer> entry:items.entrySet()){
            total+=(entry.getKey().getPrice()*entry.getValue());
        }
        return total;
    }

    public void clear(){
        items.clear();
    }


}
