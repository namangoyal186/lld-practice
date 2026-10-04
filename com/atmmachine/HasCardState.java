package com.atmmachine;

public class HasCardState implements ATMState{
    @Override
    public void insertCard(ATMSystem atm, String cardNumber) {
        System.out.println("ATM machine is already having card");
    }

    @Override
    public void enterPin(ATMSystem atm, String pin) {
        boolean authenticated = atm.getBankService().authenticate(atm.getCurrentCard(),pin);
        if(authenticated){
            atm.changeState(new AuthenticatedState());
            System.out.println("PIN validated successfully. Select an operation.");
        }
        else{
            System.out.println("Incorrect pin. Card ejected");
            atm.setCurrentCard(null);
            atm.changeState(new IdleState());
        }
    }

    @Override
    public void selectOperation(ATMSystem atm, OperationType opType, int... args) {
        System.out.println("Authenticate by entering PIN first.");
    }

    @Override
    public void ejectCard(ATMSystem atm) {
        System.out.println("Card Ejected");
        atm.setCurrentCard(null);
        atm.changeState(new IdleState());
    }
}
