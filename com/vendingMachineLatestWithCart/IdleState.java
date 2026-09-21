package com.vendingMachineLatestWithCart;

public class IdleState implements VendingMachineState {
    @Override
    public void insertMoney(VendingMachine vendingMachine, double amount, PaymentStrategy paymentStrategy) {
        if(paymentStrategy.pay(amount)){
            vendingMachine.addBalance(amount);
            vendingMachine.setCurrState(vendingMachine.getHasMoneyState());
            System.out.println("Current Machine Balance :" + vendingMachine.getBalance());
        }
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("No item selected or paid for");
    }

    @Override
    public void refund(VendingMachine vendingMachine) {
        System.out.println("No balance to refund");
    }

    @Override
    public void checkout(VendingMachine vendingMachine) {
        System.out.println("Please add items and pay first");
    }

    @Override
    public void addItemsToCart(VendingMachine vendingMachine, String code, int quantity) {
        Item item = vendingMachine.getInventory().getItem(code);
        if(!vendingMachine.getInventory().isAvailable(code,quantity)){
            System.out.println("Selected quantity is more than available");
            return;
        }
        vendingMachine.getCart().addItem(item,quantity);
        System.out.println("Added " + item.getName() + " Quantity " + quantity + " in cart");
    }
}
