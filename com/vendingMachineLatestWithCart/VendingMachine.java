package com.vendingMachineLatestWithCart;

public class VendingMachine {
    private static VendingMachine vendingMachineInstance;

    private VendingMachineState idleState;
    private VendingMachineState hasMoneyState;
    private VendingMachineState dispenseState;

    private VendingMachineState currState;
    private Inventory inventory;
    private double balance;
    private String selectedCode;
    private Cart cart;

    private VendingMachine() {
        idleState = new IdleState();
        hasMoneyState = new HasMoneyState();
        dispenseState = new DispenseState();
        cart = new Cart();

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

    public void addItemsToCart(String code, int quantity){
        currState.addItemsToCart(this,code,quantity);
    }

    public void checkout(){
        currState.checkout(this);
    }

    public void insertMoney(double amount, PaymentStrategy paymentStrategy){
        currState.insertMoney(this,amount,paymentStrategy);
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

    public Cart getCart() {
        return cart;
    }
}
