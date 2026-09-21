package com.vendingmachineTraditional;

public class CashPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {
        System.out.println("Accepted cash payment of " + amount);
        return true;
    }
}
