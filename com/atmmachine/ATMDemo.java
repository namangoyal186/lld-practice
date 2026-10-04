package com.atmmachine;

public class ATMDemo {
    public static void main(String[] args){
        BankService bankService = new BankService();
        CashDispenser cashDispenser = new CashDispenser();
        ATMSystem atmSystem = ATMSystem.getInstance(bankService,cashDispenser);

        Account account = bankService.createAccount("ACC-9585",1500.0);
        Card card = bankService.createCard("CARD-1234","2453");
        bankService.linkCardToAccount(card,account);

        System.out.println("=== 1. Check Balance ===");
        atmSystem.insertCard("CARD-1234");
        atmSystem.enterPin("2453");
        atmSystem.selectOperation(OperationType.CHECK_BALANCE);
        atmSystem.ejectCard();

        System.out.println("\n=== 2. Cash Withdrawal ===");
        atmSystem.insertCard("CARD-1234");
        atmSystem.enterPin("2453");
        atmSystem.selectOperation(OperationType.WITHDRAW_MONEY,270);
        atmSystem.selectOperation(OperationType.CHECK_BALANCE);
        atmSystem.ejectCard();

        System.out.println("\n=== 3. Invalid PIN Attempt ===");
        atmSystem.insertCard("CARD-1234");
        atmSystem.enterPin("0000");


    }




}
