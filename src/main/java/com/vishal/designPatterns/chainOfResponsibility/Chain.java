package com.vishal.designPatterns.chainOfResponsibility;

public abstract class Chain {
    protected Chain nextInChain;

    public Chain(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    public abstract boolean processRequest(int amt);

    protected void reduceMoneyFromStore(int noteAmount, int noOfNotes, int noOfNotesUsed) {
        MoneyStore.getDenominationMap().put(noteAmount, noOfNotes - noOfNotesUsed);
        System.out.println("No. of " + noteAmount + " notes used : " + noOfNotesUsed);
    }
}
