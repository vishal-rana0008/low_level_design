package com.vishal.vendingMachine.model.impl;

import com.vishal.vendingMachine.VendingMachine;
import com.vishal.vendingMachine.enums.StateType;
import com.vishal.vendingMachine.factory.StateFactory;
import com.vishal.vendingMachine.model.State;


public class IdleState extends State {

    public IdleState(VendingMachine vendingMachine) {
        super(vendingMachine);
        this.vendingMachine.setCoins(0);
        this.vendingMachine.clearInputData();
    }

    @Override
    public String acceptCoinsButtonAction() {
        vendingMachine.setState(StateFactory.createState(StateType.CONSUMING_COINS_STATE, vendingMachine));
        return "Insert Coins ...";
    }

    @Override
    public String selectProductButtonAction() {
        return "Invalid Input : First insert coins !!";
    }

    @Override
    public String dispenseProductButtonAction() {
        return "Invalid Input : First insert coins !!";
    }

    @Override
    public String cancelButtonAction() {
        return "";
    }
}
