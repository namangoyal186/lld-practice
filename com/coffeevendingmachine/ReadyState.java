package com.coffeevendingmachine;

public class ReadyState implements VendingMachineState{

    @Override
    public void insertMoney(CoffeeVendingMachine machine, int amount) {
        System.out.println("Please select your coffee before inserting money");
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine machine) {
        System.out.println("No coffee selected");
    }

    @Override
    public void cancel(CoffeeVendingMachine machine) {
        System.out.println("Already in ready state. Nothing to cancel");
    }

    @Override
    public void selectCoffee(CoffeeVendingMachine machine, Coffee coffee) {
        machine.setSelectedCoffee(coffee);
        System.out.println("Selected " + coffee.getCoffeeType() + ". Price: " + coffee.getPrice());
        machine.setVendingMachineState(new SelectingState());
    }
}
