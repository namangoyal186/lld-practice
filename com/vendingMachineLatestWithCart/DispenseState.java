package com.vendingMachineLatestWithCart;

import java.util.Map;

public class DispenseState implements VendingMachineState {
    @Override
    public void insertMoney(VendingMachine vendingMachine, double amount, PaymentStrategy paymentStrategy) {
        System.out.println("Insert money operation not available during dispense time");
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        double totalCost = vendingMachine.getCart().calculateTotal();
        System.out.println(vendingMachine.getCurrState());

        for(Map.Entry<Item,Integer> entry:vendingMachine.getCart().getItems().entrySet()){
            Item item = entry.getKey();
            int quantity = entry.getValue();
            for(int i=0;i<quantity;i++){
                vendingMachine.getInventory().removeItem(item.getCode());
            }
            System.out.println("Item Dispensed " + item.getName() + " Quantity " + quantity);
        }

        double change = vendingMachine.getBalance()-totalCost;
        if(change>0){
            System.out.println("Returning change " + change);
        }
        vendingMachine.resetBalance();
        vendingMachine.getCart().clear();
        vendingMachine.setCurrState(vendingMachine.getIdleState());
        System.out.println("=== Transaction Complete. Ready for next user. ===\n");
    }

    @Override
    public void refund(VendingMachine vendingMachine) {
        System.out.println("Cannot refund while dispensing");
    }

    @Override
    public void checkout(VendingMachine vendingMachine) {
        System.out.println("Already dispensing");
    }

    @Override
    public void addItemsToCart(VendingMachine vendingMachine, String code, int quantity) {
        System.out.println("Vending machine is in dispensing state");
    }
}
