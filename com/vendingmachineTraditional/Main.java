package com.vendingmachineTraditional;

public class Main {
    public static void main(String[] args){
        VendingMachine vendingMachine = VendingMachine.getInstance();

        //Setup Inventory
        System.out.println("=== 1. Initializing Vending Machine Inventory ===");
        vendingMachine.getInventory().addItem(new Item("A1","Coke",1.50),10);
        vendingMachine.getInventory().addItem(new Item("A2","Chips",2.0),10);
        vendingMachine.getInventory().addItem(new Item("A3","Chocolate",5.0),0);
        System.out.println(vendingMachine.getCurrState());

        // 2. Scenario 1: Successful purchase with change returned (Cash)
        System.out.println("\n=== 2. Scenario 2: Buy Coke with Cash (Extra money added) ===");
        vendingMachine.insertMoney(2.0,new CashPaymentStrategy());
        System.out.println(vendingMachine.getCurrState());
        vendingMachine.selectItem("A1");
        System.out.println(vendingMachine.getCurrState());

        // 2. Scenario 2: Successful purchase with Card
        System.out.println("\n=== 2. Scenario 3: Buy Chips with Card");
        vendingMachine.insertMoney(2.0,new CardPaymentStrategy());
        System.out.println(vendingMachine.getCurrState());
        vendingMachine.selectItem("A2");
        System.out.println(vendingMachine.getCurrState());

        // 4. Scenario 3: Attempting to buy an out-of-stock item
        System.out.println("\n=== 4. Scenario 4: Try buying out-of-stock Chocolate ===");
        vendingMachine.insertMoney(5.0, new CardPaymentStrategy());
        System.out.println(vendingMachine.getCurrState());
        vendingMachine.selectItem("A3"); // Item is 0 stock
        System.out.println(vendingMachine.getCurrState());

        // Since transaction failed due to stock, let's trigger a refund for the remaining balance
        System.out.println("\n--- Triggering Refund after Failed Purchase ---");
        vendingMachine.refund();
        System.out.println(vendingMachine.getCurrState());

        // 5. Scenario 4: Insufficient funds error workflow
        System.out.println("\n=== 5. Scenario 5: Insufficient Funds & Manual Refund ===");
        vendingMachine.insertMoney(1.00, new CashPaymentStrategy());
        System.out.println(vendingMachine.getCurrState());
        vendingMachine.selectItem("A1"); // Coke costs $1.50, but we only have $1.00
        System.out.println(vendingMachine.getCurrState());
        vendingMachine.refund();        // Getting money back manually
        System.out.println(vendingMachine.getCurrState());




    }
}
