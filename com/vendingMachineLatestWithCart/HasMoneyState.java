package com.vendingMachineLatestWithCart;

public class HasMoneyState implements VendingMachineState {
    @Override
    public void insertMoney(VendingMachine vendingMachine, double amount, PaymentStrategy paymentStrategy) {
        if(paymentStrategy.pay(amount)){
            vendingMachine.addBalance(amount);
            System.out.println("Additional money added. Total balance now " + vendingMachine.getBalance());
        }
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("Select an item first");
    }

    @Override
    public void refund(VendingMachine vendingMachine) {
        System.out.println("Refunding total balance: $" + vendingMachine.getBalance());
        vendingMachine.resetBalance();
        vendingMachine.setCurrState(vendingMachine.getIdleState());
    }

    @Override
    public void checkout(VendingMachine vendingMachine) {
        double totalCost = vendingMachine.getCart().calculateTotal();
        if(totalCost>vendingMachine.getBalance()){
            System.out.println("Insufficient funds! Total required: $" + totalCost + ", Current Balance: $" + vendingMachine.getBalance());
            return;
        }
        vendingMachine.setCurrState(vendingMachine.getDispenseState());
        vendingMachine.getCurrState().dispense(vendingMachine);
    }

    @Override
    public void addItemsToCart(VendingMachine vendingMachine, String code, int quantity) {
        if(!vendingMachine.getInventory().isAvailable(code, quantity)){
            System.out.println("Selected quantity is more than available");
            return;
        }
        Item item = vendingMachine.getInventory().getItem(code);
        vendingMachine.getCart().addItem(item,quantity);
        System.out.println("Added new items New Total " + vendingMachine.getCart().calculateTotal());
    }
}
