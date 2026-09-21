package com.vendingmachineTraditional;

public interface VendingMachineState {
    public void insertMoney(VendingMachine vendingMachine, double amount, PaymentStrategy paymentStrategy);
    public void dispense(VendingMachine vendingMachine);
    public void refund(VendingMachine vendingMachine);
    public void selectItem(VendingMachine vendingMachine, String code);
}
