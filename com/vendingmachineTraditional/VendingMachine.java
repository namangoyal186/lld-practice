package com.vendingmachineTraditional;

public class VendingMachine {
    private static VendingMachine vendingMachineInstance;

    private VendingMachineState idleState;
    private VendingMachineState hasMoneyState;
    private VendingMachineState dispenseState;

    private VendingMachineState currState;
    private Inventory inventory;
    private double balance;
    private String selectedCode;

    private VendingMachine() {
        idleState = new IdleState();
        hasMoneyState = new HasMoneyState();
        dispenseState = new DispenseState();

        currState = idleState;
        inventory = new Inventory();
        balance = 0.0;
    }

    public static synchronized VendingMachine getInstance(){
        if (vendingMachineInstance==null){
            vendingMachineInstance=new VendingMachine();
        }
        return vendingMachineInstance;
    }

    public void insertMoney(double amount, PaymentStrategy paymentStrategy){
        currState.insertMoney(this,amount,paymentStrategy);
    }

    public void selectItem(String code){
        currState.selectItem(this,code);
    }

    public void refund(){
        currState.refund(this);
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getHasMoneyState() {
        return hasMoneyState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    public VendingMachineState getCurrState() {
        return currState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount){
        this.balance+=amount;
    }

    public void resetBalance(){
        this.balance=0.0;
    }

    public String getSelectedCode() {
        return selectedCode;
    }

    public void setSelectedCode(String selectedCode) {
        this.selectedCode = selectedCode;
    }

    public void setCurrState(VendingMachineState currState) {
        this.currState = currState;
    }
}
