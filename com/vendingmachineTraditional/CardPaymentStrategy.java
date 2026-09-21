package com.vendingmachineTraditional;

public class CardPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {
        System.out.println("Accepted Card payment of " + amount + " through Razorpay payment gateway");
        return true;
    }
}
