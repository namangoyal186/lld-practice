package com.atmmachine;

public interface ATMState {
    void insertCard(ATMSystem atm, String cardNumber);
    void enterPin(ATMSystem atm, String pin);
    void selectOperation(ATMSystem atm, OperationType opType, int... args);
    void ejectCard(ATMSystem atm);
}
