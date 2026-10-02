package com.coffeevendingmachine;

public class SelectingState implements VendingMachineState{
    @Override
    public void insertMoney(CoffeeVendingMachine machine, int amount) {
        int total = machine.getMoneyInserted() + amount;
        machine.setMoneyInserted(total);
        System.out.println("Inserted: " + amount + ". Total inserted: " + total);
        if(total>=machine.getSelectedCoffee().getPrice()){
            machine.setVendingMachineState(new PaidState());
            System.out.println("Payment complete. Ready to dispense.");
        }
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine machine) {
        System.out.println("Insufficient funds. Please insert money first.");
    }

    @Override
    public void cancel(CoffeeVendingMachine machine) {
        System.out.println("Order Cancelled");
        if(machine.getMoneyInserted()>0){
            System.out.println("Refunding inserted money: " + machine.getMoneyInserted());
        }
        machine.reset();
    }

    @Override
    public void selectCoffee(CoffeeVendingMachine machine, Coffee coffee) {
        machine.setSelectedCoffee(coffee);
        System.out.println("Selection changed to " + coffee.getCoffeeType());
    }
}
