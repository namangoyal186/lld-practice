package com.coffeevendingmachine;

public class OutOfIngredientState implements VendingMachineState{

    @Override
    public void insertMoney(CoffeeVendingMachine machine, int amount) {
        System.out.println("Machine is out of ingredients. Money returned: " + amount);
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine machine) {
        System.out.println("Cannot dispense. Out of ingredients.");
    }

    @Override
    public void cancel(CoffeeVendingMachine machine) {
        machine.reset();
    }

    @Override
    public void selectCoffee(CoffeeVendingMachine machine, Coffee coffee) {
        System.out.println("Cannot select coffee. Ingredients are depleted.");
    }
}
