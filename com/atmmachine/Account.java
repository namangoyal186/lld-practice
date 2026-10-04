package com.atmmachine;
import java.util.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String accountNumber;
    private double balance;
    Map<String,Card> cards = new ConcurrentHashMap<>();
    private ReentrantLock lock = new ReentrantLock();

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public double checkBalance(){
        lock.lock();
        try{
            return balance;
        }
        finally {
            lock.unlock();
        }
    }

    public boolean withdraw(double amount){
        lock.lock();
        try{
            if(balance<=0 || balance<amount){
                return false;
            }
            balance=balance-amount;
            return true;
        }
        finally {
            lock.unlock();
        }
    }

    public void depositMoney(double amount){
        lock.lock();
        try{
            balance+=amount;
        }
        finally {
            lock.unlock();
        }
    }

    public void addCards(Card card){
        cards.put(card.getCardNumber(),card);
    }
}
