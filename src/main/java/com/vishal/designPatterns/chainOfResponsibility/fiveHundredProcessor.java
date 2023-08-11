package com.vishal.designPatterns.chainOfResponsibility;

public class fiveHundredProcessor extends Chain {

    public fiveHundredProcessor(Chain nextInChain) {
        super(nextInChain);
    }

    @Override
    public boolean processRequest(int amt) {
        boolean reqSatisfied = false;
        int noOf500Notes = MoneyStore.getDenominationMap().get(500);

        int noOf500NotesNeeded = amt / 500;
        int noOf500NotesUsed = Math.min(noOf500Notes, noOf500NotesNeeded);
        int remainingAmt = amt - 500 * noOf500NotesUsed;

        if (remainingAmt > 0) {
            if (nextInChain != null && nextInChain.processRequest(remainingAmt)) {
                reduceMoneyFromStore(500, noOf500Notes, noOf500NotesUsed);
                reqSatisfied = true;
            }
        } else {
            reduceMoneyFromStore(500, noOf500Notes, noOf500NotesUsed);
            reqSatisfied = true;
        }

        return reqSatisfied;
    }
}
