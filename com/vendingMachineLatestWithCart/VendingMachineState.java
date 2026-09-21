package com.vendingMachineLatestWithCart;

public interface VendingMachineState {
    public void insertMoney(VendingMachine vendingMachine, double amount, PaymentStrategy paymentStrategy);
    public void dispense(VendingMachine vendingMachine);
    public void refund(VendingMachine vendingMachine);
    public void checkout(VendingMachine vendingMachine);
    public void addItemsToCart(VendingMachine vendingMachine, String code, int quantity);
}
