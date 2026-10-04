package com.atmmachine;

public class AuthenticatedState implements ATMState{
    @Override
    public void insertCard(ATMSystem atm, String cardNumber) {
        System.out.println("A session is currently active");
    }

    @Override
    public void enterPin(ATMSystem atm, String pin) {
        System.out.println("User is already authenticated.");
    }

    @Override
    public void selectOperation(ATMSystem atm, OperationType opType, int... args) {
        switch(opType){
            case CHECK_BALANCE:
                atm.checkBalance();
                break;
            case WITHDRAW_MONEY:
                if(args.length>0) atm.withdrawCash(args[0]);
                else System.out.println("Provide withdrawal amount");
                break;
            case DEPOSIT_CASH:
                if(args.length>0) atm.depositCash(args[0]);
                else System.out.println("Provide deposit amount");
                break;
            default:
                System.out.println("Invalid Operation");
                break;
        }
    }

    @Override
    public void ejectCard(ATMSystem atm) {
        System.out.println("Card ejected. Session ended");
        atm.setCurrentCard(null);
        atm.changeState(new IdleState());
    }
}
