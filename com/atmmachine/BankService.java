package com.atmmachine;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BankService {
    Map<String,Account> accounts = new ConcurrentHashMap<>();
    Map<String,Card> cards = new ConcurrentHashMap<>();
    Map<Card,Account> cardAccountMap = new ConcurrentHashMap<>();

    public Account createAccount(String accountNumber, double initialBalance){
        Account account = new Account(accountNumber,initialBalance);
        accounts.put(accountNumber,account);
        return account;
    }

    public Card createCard(String cardNumber, String pin){
        Card card = new Card(cardNumber,pin);
        cards.put(cardNumber,card);
        return card;
    }

    public void linkCardToAccount(Card card,Account account){
        cardAccountMap.put(card,account);
        account.addCards(card);
    }

    public Card getCard(String cardNumber){
        return cards.get(cardNumber);
    }

    public boolean authenticate(Card card, String enteredPin){
        return card!=null && card.getPin().equals(enteredPin);
    }

    public double getBalance(Card card){
        Account account = cardAccountMap.get(card);
        if(account==null){
            throw new IllegalStateException("Account is not linked to card");
        }
        return account.checkBalance();
    }

    public boolean withdrawMoney(Card card, double amount){
        Account account= cardAccountMap.get(card);
        return account!=null && account.withdraw(amount);
    }

    public void depositMoney(Card card, double amount){
        Account account = cardAccountMap.get(card);
        if(account==null){
            throw new IllegalStateException("Account is not linked to card");
        }
        account.depositMoney(amount);
    }
}
