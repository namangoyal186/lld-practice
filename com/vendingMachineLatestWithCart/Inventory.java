package com.vendingMachineLatestWithCart;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private Map<String, Item> itemCatalog = new ConcurrentHashMap<>();
    private Map<String,Integer> itemStock = new ConcurrentHashMap<>();

    public void addItem(Item item, int quantity){
        itemCatalog.put(item.getCode(),item);
        itemStock.put(item.getCode(),itemStock.getOrDefault(item.getCode(),0)+quantity);
    }

    public boolean isAvailable(String code, int quantity){
        return itemStock.getOrDefault(code,0)>quantity;
    }

    public void removeItem(String code){
        itemStock.put(code,itemStock.get(code)-1);
    }

    public Item getItem(String code){
        return itemCatalog.get(code);
    }


}
