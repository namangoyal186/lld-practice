package com.coffeevendingmachine;
import java.util.*;

public class CoffeeVendingMachine {
    private static CoffeeVendingMachine coffeeVendingMachineInstance;
    private VendingMachineState vendingMachineState;
    private int moneyInserted;
    private CoffeeFactory coffeeFactory;
    private Coffee selectedCoffee;


    private CoffeeVendingMachine() {
        this.vendingMachineState=new ReadyState();
        this.moneyInserted = 0;
        this.coffeeFactory = new CoffeeFactory();
        this.selectedCoffee = null;
    }

    public static synchronized CoffeeVendingMachine getInstance(){
        if(coffeeVendingMachineInstance==null){
            synchronized (CoffeeVendingMachine.class){
                if(coffeeVendingMachineInstance==null){
                    coffeeVendingMachineInstance=new CoffeeVendingMachine();
                }
            }
        }
        return coffeeVendingMachineInstance;
    }

    public synchronized void selectCoffee(CoffeeType coffeeType,List<ToppingType> toppings){
        Coffee coffee = coffeeFactory.createCoffee(coffeeType);

        if(toppings!=null){
            for(ToppingType toppingType:toppings){
                switch (toppingType){
                    case EXTRA_SUGAR:
                        coffee = new ExtraSugarDecorator(coffee);
                        break;
                    case CARAMEL_SYRUP:
                        coffee = new ExtraCaramelDecorator(coffee);
                        break;
                }
            }
        }

        vendingMachineState.selectCoffee(this,coffee);
    }

    public synchronized void insertMoney(int amount){
        vendingMachineState.insertMoney(this,amount);
    }

    public synchronized void dispenseCoffee(){
        vendingMachineState.dispenseCoffee(this);
    }

    public synchronized void cancel(){
        vendingMachineState.cancel(this);
    }

    public synchronized void reset(){
        this.moneyInserted=0;
        this.selectedCoffee=null;
        this.vendingMachineState = new ReadyState();
    }

    //getter and setter

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public Coffee getSelectedCoffee() {
        return selectedCoffee;
    }

    public void setSelectedCoffee(Coffee selectedCoffee) {
        this.selectedCoffee = selectedCoffee;
    }

    public int getMoneyInserted() {
        return moneyInserted;
    }

    public void setMoneyInserted(int moneyInserted) {
        this.moneyInserted = moneyInserted;
    }
}
