package com.atmmachine;

public abstract class NoteDispenser implements DispenseChain {
    protected int noteValue;
    protected int numNotes;
    protected DispenseChain nextChain;

    public NoteDispenser(int noteValue, int numNotes) {
        this.noteValue = noteValue;
        this.numNotes = numNotes;
    }


    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain=nextChain;
    }

    @Override
    public boolean canDispense(int amount) {
        int notesNeeded=amount/noteValue;
        int notesToUse=Math.min(notesNeeded,numNotes);
        int remainder=amount-(notesToUse*noteValue);
        if(remainder==0) return true;
        return nextChain!=null && nextChain.canDispense(remainder);
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded=amount/noteValue;
        int notesToUse=Math.min(notesNeeded,numNotes);
        int remainder=amount-(notesToUse*noteValue);

        if(notesToUse>0){
            numNotes-=notesToUse;
            System.out.println("Dispensing " + notesToUse + " x $" + noteValue + " note(s)");
        }

        if(remainder>0 && nextChain!=null){
            nextChain.dispense(remainder);
        }

    }
}
