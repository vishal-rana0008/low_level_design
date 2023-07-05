package com.vishal.vendingMachine.model.impl;

import com.vishal.vendingMachine.VendingMachine;
import com.vishal.vendingMachine.enums.StateType;
import com.vishal.vendingMachine.factory.StateFactory;
import com.vishal.vendingMachine.model.State;

public class ConsumingCoinsState extends State {

    public ConsumingCoinsState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public String acceptCoinsButtonAction() {
        return "";
    }

    @Override
    public String selectProductButtonAction() {
        vendingMachine.setState(StateFactory.createState(StateType.PRODUCT_SELECTION_STATE, vendingMachine));
        return "Enter item number in keypad ...";
    }

    @Override
    public String dispenseProductButtonAction() {
        return "Invalid Input : First select product !!";
    }

    @Override
    public String cancelButtonAction() {
        vendingMachine.setState(StateFactory.createState(StateType.IDLE_STATE, vendingMachine));
        return "If you had inserted coins, then pls collect them";
    }
}
