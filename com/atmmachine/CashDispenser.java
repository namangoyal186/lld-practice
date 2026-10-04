package com.atmmachine;

public class CashDispenser {
    private DispenseChain dispenseChain;

    public CashDispenser() {
        DispenseChain c100=new NoteDispenser100(50);
        DispenseChain c50=new NoteDispenser50(50);
        DispenseChain c20=new NoteDispenser20(50);

        c100.setNextChain(c50);
        c50.setNextChain(c20);
        this.dispenseChain=c100;
    }

    public synchronized boolean canDispenseCash(int amount){
        return dispenseChain.canDispense(amount);
    }

    public synchronized void dispenseCash(int amount){
        dispenseChain.dispense(amount);
    }
}
