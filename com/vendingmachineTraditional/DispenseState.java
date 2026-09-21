package com.vendingmachineTraditional;

public class DispenseState implements VendingMachineState{
    @Override
    public void insertMoney(VendingMachine vendingMachine, double amount, PaymentStrategy paymentStrategy) {
        System.out.println("Insert money operation not available during dispense time");
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println(vendingMachine.getCurrState());
        String code = vendingMachine.getSelectedCode();
        Item item = vendingMachine.getInventory().getItem(code);
        vendingMachine.getInventory().removeItem(code);

        double change = vendingMachine.getBalance()-item.getPrice();
        System.out.println("Dispensing item : " + item.getName());
        if(change>0){
            System.out.println("Returning change " + change);
        }
        vendingMachine.resetBalance();
        vendingMachine.setSelectedCode(null);
        vendingMachine.setCurrState(vendingMachine.getIdleState());
    }

    @Override
    public void refund(VendingMachine vendingMachine) {
        System.out.println("Cannot refund while dispensing");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String code) {
        System.out.println("Please wait, currently dispensing");
    }
}
