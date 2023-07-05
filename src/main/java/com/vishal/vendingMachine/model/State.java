package com.vishal.vendingMachine.model;

import com.vishal.vendingMachine.VendingMachine;

public abstract class State {
    protected VendingMachine vendingMachine;

    public State(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public abstract String acceptCoinsButtonAction();
    public abstract String selectProductButtonAction();
    public abstract String dispenseProductButtonAction();
    public abstract String cancelButtonAction();
}
