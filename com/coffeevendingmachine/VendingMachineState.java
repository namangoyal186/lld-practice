package com.coffeevendingmachine;

public interface VendingMachineState {
    public void insertMoney(CoffeeVendingMachine machine, int amount);
    public void dispenseCoffee(CoffeeVendingMachine machine);
    public void cancel(CoffeeVendingMachine machine);
    public void selectCoffee(CoffeeVendingMachine machine, Coffee coffee);
}
