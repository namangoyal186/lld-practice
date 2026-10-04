package com.atmmachine;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class ATMSystem {
    private static ATMSystem atmSystemInstance;
    private AtomicLong transactionCounter = new AtomicLong(1000);
    private ATMState currentState;
    private Card currentCard;
    private CashDispenser cashDispenser;
    private BankService bankService;

    private ATMSystem(CashDispenser cashDispenser, BankService bankService){
        this.currentState=new IdleState();
        this.cashDispenser=cashDispenser;
        this.bankService=bankService;
    }

    public synchronized static ATMSystem getInstance(BankService bankService, CashDispenser cashDispenser){
        if(atmSystemInstance==null){
            synchronized (ATMSystem.class){
                if(atmSystemInstance==null){
                    atmSystemInstance = new ATMSystem(cashDispenser,bankService);
                }
            }
        }
        return atmSystemInstance;
    }

    //User Operations

    public void insertCard(String card){
        currentState.insertCard(this,card);
    }

    public void enterPin(String pin){
        currentState.enterPin(this,pin);
    }

    public void selectOperation(OperationType opType, int... args){
        currentState.selectOperation(this,opType,args);
    }

    public void ejectCard(){
        currentState.ejectCard(this);
    }

    //Business Operations

    public void checkBalance(){
        double balance=bankService.getBalance(currentCard);
        System.out.println("[Txn #" + transactionCounter.incrementAndGet() + "] Current Balance: $" + balance);
    }

    public void withdrawCash(int amount){
        if(!cashDispenser.canDispenseCash(amount)){
            System.out.println("ATM does not have exact denominations for $" + amount);
            return;
        }
        boolean debited = bankService.withdrawMoney(currentCard,amount);
        if(debited){
            cashDispenser.dispenseCash(amount);
            System.out.println("[Txn #" + transactionCounter.incrementAndGet() + "] Successfully withdrawn: $" + amount);
        }
        else{
            System.out.println("Insufficient funds or invalid transaction");
        }
    }

    public void depositCash(int amount){
        bankService.depositMoney(currentCard,amount);
    }

    //State management Getter


    public ATMState getCurrentState() {
        return currentState;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public BankService getBankService() {
        return bankService;
    }

    public void changeState(ATMState atmState){
        this.currentState=atmState;
    }

    public void setCurrentCard(Card card){
        this.currentCard=card;
    }
}
