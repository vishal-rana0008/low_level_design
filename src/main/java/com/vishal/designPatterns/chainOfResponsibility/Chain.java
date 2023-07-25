package com.vishal.designPatterns.chainOfResponsibility;

public abstract class Chain {
    protected Chain nextInChain;

    public Chain(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    public abstract boolean processRequest(int amt);
}
