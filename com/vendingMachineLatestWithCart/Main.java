package com.vendingMachineLatestWithCart;

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
        System.out.println("\n=== 2. Scenario 2: Buy Coke and chips with Cash (Extra money added) ===");
        System.out.println(vendingMachine.getCurrState());
        vendingMachine.addItemsToCart("A1",1);
        vendingMachine.addItemsToCart("A2",1);
        vendingMachine.insertMoney(5.0,new CashPaymentStrategy());
        System.out.println(vendingMachine.getCurrState());
        vendingMachine.checkout();

        // 2. Scenario 2: Successful purchase with Card
        System.out.println("\n=== 2. Scenario 3: Buy chocolate with Card");
        vendingMachine.addItemsToCart("A2", 2);
        vendingMachine.insertMoney(4.00, new CardPaymentStrategy());
        vendingMachine.checkout();

        // 4. Scenario 3: Attempting to buy an out-of-stock item
        System.out.println("\n=== 4. Scenario 4: Try buying out-of-stock Chocolate ===");
        vendingMachine.addItemsToCart("A3",5);
        vendingMachine.addItemsToCart("A2",3);
        vendingMachine.insertMoney(100.0, new CashPaymentStrategy());
        System.out.println(vendingMachine.getCurrState());
        vendingMachine.checkout();
        System.out.println(vendingMachine.getCurrState());
        // Since transaction failed due to stock, let's trigger a refund for the remaining balance
        System.out.println("\n--- Triggering Refund after Failed Purchase ---");
        vendingMachine.refund();
        System.out.println(vendingMachine.getCurrState());

        // 5. Scenario 4: Insufficient funds error workflow
        System.out.println("\n=== 5. Scenario 5: Insufficient Funds & Manual Refund ===");
        vendingMachine.addItemsToCart("A1",1);
        vendingMachine.insertMoney(1.00, new CashPaymentStrategy());
        System.out.println(vendingMachine.getCurrState());
        vendingMachine.checkout(); // Coke costs $1.50, but we only have $1.00
        System.out.println(vendingMachine.getCurrState());
        vendingMachine.refund();        // Getting money back manually
        System.out.println(vendingMachine.getCurrState());




    }
}
