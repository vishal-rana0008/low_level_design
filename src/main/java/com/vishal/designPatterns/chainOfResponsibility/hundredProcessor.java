package com.vishal.designPatterns.chainOfResponsibility;

public class hundredProcessor extends Chain {

    public hundredProcessor(Chain nextInChain) {
        super(nextInChain);
    }

    @Override
    public boolean processRequest(int amt) {
        boolean reqSatisfied = false;
        int noOf100Notes = MoneyStore.getDenominationMap().get(100);

        int noOf100NotesNeeded = amt / 100;
        int noOf100NotesUsed = Math.min(noOf100Notes, noOf100NotesNeeded);
        int remainingAmt = amt - 100 * noOf100NotesUsed;

        if (remainingAmt > 0) {
            if (nextInChain != null && nextInChain.processRequest(remainingAmt)) {
                reduceMoneyFromStore(100, noOf100Notes, noOf100NotesUsed);
                reqSatisfied = true;
            }
        } else {
            reduceMoneyFromStore(100, noOf100Notes, noOf100NotesUsed);
            reqSatisfied = true;
        }

        return reqSatisfied;
    }
}
