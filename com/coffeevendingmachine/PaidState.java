package com.coffeevendingmachine;

public class PaidState implements VendingMachineState{
    @Override
    public void insertMoney(CoffeeVendingMachine machine, int amount) {
        System.out.println("Already paid full amount. Returning additional money: " + amount);
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine machine) {
        Inventory inventory = Inventory.getInstance();
        Coffee coffee = machine.getSelectedCoffee();

        if(!inventory.hasIngredients(coffee.getRecipe())){
            System.out.println("Out of ingredients. Refunding money " + machine.getMoneyInserted());
            machine.setVendingMachineState(new OutOfIngredientState());
            machine.reset();
            return;
        }

        inventory.deductIngredients(coffee.getRecipe());
        System.out.println("Dispensing " + coffee.getCoffeeType() + "...");
        coffee.prepare();

        int change = machine.getMoneyInserted()-coffee.getPrice();
        if(change>0){
            System.out.println("Refunding extra amount " + change);
        }

        System.out.println("Enjoy your coffee");
        machine.reset();
    }

    @Override
    public void cancel(CoffeeVendingMachine machine) {
        System.out.println("Cancelling your current coffee order and refunding money " + machine.getMoneyInserted());
        machine.reset();

    }

    @Override
    public void selectCoffee(CoffeeVendingMachine machine, Coffee coffee) {
        System.out.println("Cannot change selection after payment. Please cancel or dispense.");
    }
}
