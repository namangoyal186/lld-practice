package com.coffeevendingmachine;

import java.util.Arrays;
import java.util.Collections;

public class CoffeeVendingMachineDemo {
    public static void main(String[] args){
        CoffeeVendingMachine coffeeVendingMachine = CoffeeVendingMachine.getInstance();
        Inventory.getInstance().printInventory();

        //1. Successful order with multiple toppings
        System.out.println("Order 1: Latte with Sugar and Caramel");
        coffeeVendingMachine.selectCoffee(CoffeeType.LATTE, Arrays.asList(ToppingType.EXTRA_SUGAR,ToppingType.CARAMEL_SYRUP));
        coffeeVendingMachine.insertMoney(100);
        coffeeVendingMachine.insertMoney(100);
        coffeeVendingMachine.dispenseCoffee();

        //2. Cancellation scenario
        System.out.println();
        System.out.println("Order2: Espresso cancelled midaway");
        coffeeVendingMachine.selectCoffee(CoffeeType.ESPRESSO, Collections.emptyList());
        coffeeVendingMachine.cancel();
        coffeeVendingMachine.insertMoney(100);


        //Checking remaining inventory
        System.out.println();
        Inventory.getInstance().printInventory();



    }
}
