package com.vendingmachineTraditional;

public class HasMoneyState implements VendingMachineState{
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
    public void selectItem(VendingMachine vendingMachine, String code) {
        if(!vendingMachine.getInventory().isAvailable(code)){
            System.out.println("Item is out of stock");
            return;
        }
        Item item = vendingMachine.getInventory().getItem(code);
        if(vendingMachine.getBalance()<item.getPrice()){
            System.out.println("Insufficient funds.Price is " + item.getPrice() + " Vending machine balance is " + vendingMachine.getBalance() );
            return;
        }
        vendingMachine.setCurrState(vendingMachine.getDispenseState());
        vendingMachine.setSelectedCode(code);
        vendingMachine.getCurrState().dispense(vendingMachine);
    }
}
