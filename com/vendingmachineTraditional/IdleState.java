package com.vendingmachineTraditional;

public class IdleState implements VendingMachineState{
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
    public void selectItem(VendingMachine vendingMachine, String code) {
        System.out.println("Please insert money first");
    }
}
