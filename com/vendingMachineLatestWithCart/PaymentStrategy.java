package com.vendingMachineLatestWithCart;

public interface PaymentStrategy {
    public boolean pay(double amount);
}
