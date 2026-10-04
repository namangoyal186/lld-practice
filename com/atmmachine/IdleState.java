package com.atmmachine;

public class IdleState implements ATMState{
    @Override
    public void insertCard(ATMSystem atm, String cardNumber) {
        Card card = atm.getBankService().getCard(cardNumber);
        if(card!=null){
            atm.setCurrentCard(card);
            atm.changeState(new HasCardState());
            System.out.println("Card accepted. Please enter your pin");
        }
        else{
            System.out.println("Invalid card number");
        }
    }

    @Override
    public void enterPin(ATMSystem atm, String pin) {
        System.out.println("Please enter your card first");
    }

    @Override
    public void selectOperation(ATMSystem atm, OperationType opType, int... args) {
        System.out.println("Please insert a card and authenticate first.");
    }

    @Override
    public void ejectCard(ATMSystem atm) {
        System.out.println("No card to eject.");
    }
}
