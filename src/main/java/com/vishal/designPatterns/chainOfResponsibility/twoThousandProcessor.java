package com.vishal.designPatterns.chainOfResponsibility;

public class twoThousandProcessor extends Chain {

    public twoThousandProcessor(Chain nextInChain) {
        super(nextInChain);
    }

    @Override
    public boolean processRequest(int amt) {
        boolean reqSatisfied = false;
        int noOf2000Notes = MoneyStore.getDenominationMap().get(2000);

        int noOf2000NotesNeeded = amt / 2000;
        int noOf2000NotesUsed = Math.min(noOf2000Notes, noOf2000NotesNeeded);
        int remainingAmt = amt - 2000 * noOf2000NotesUsed;

        if (remainingAmt > 0) {
            if (nextInChain != null && nextInChain.processRequest(remainingAmt)) {
                reduceMoneyFromStore(2000, noOf2000Notes, noOf2000NotesUsed);
                reqSatisfied = true;
            }
        } else {
            reduceMoneyFromStore(2000, noOf2000Notes, noOf2000NotesUsed);
            reqSatisfied = true;
        }

        return reqSatisfied;
    }
}
