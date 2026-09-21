package com.vendingmachineTraditional;

public class UpiPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {
        System.out.println("Accepted UPI Payment of" + amount);
        return true;
    }
}
