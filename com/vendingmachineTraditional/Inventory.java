package com.vendingmachineTraditional;

import java.util.concurrent.ConcurrentHashMap;
import java.util.*;

public class Inventory {
    private Map<String,Item> itemCatalog = new ConcurrentHashMap<>();
    private Map<String,Integer> itemStock = new ConcurrentHashMap<>();

    public void addItem(Item item, int quantity){
        itemCatalog.put(item.getCode(),item);
        itemStock.put(item.getCode(),itemStock.getOrDefault(item.getCode(),0)+quantity);
    }

    public boolean isAvailable(String code){
        return itemStock.getOrDefault(code,0)>0;
    }

    public void removeItem(String code){
        itemStock.put(code,itemStock.get(code)-1);
    }

    public Item getItem(String code){
        return itemCatalog.get(code);
    }


}
