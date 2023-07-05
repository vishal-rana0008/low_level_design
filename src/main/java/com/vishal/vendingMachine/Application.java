package com.vishal.vendingMachine;

import com.vishal.vendingMachine.enums.StateType;
import com.vishal.vendingMachine.factory.StateFactory;
import com.vishal.vendingMachine.model.impl.KeyPad;

public class Application {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance(null, new KeyPad());
        vendingMachine.setState(StateFactory.createState(StateType.IDLE_STATE, vendingMachine));

        System.out.println(vendingMachine.pressAcceptCoinsButton());
        vendingMachine.setCoins(100);
        System.out.println(vendingMachine.pressCancelButton());
        System.out.println(vendingMachine.pressSelectProductButton());
        vendingMachine.insertInputCharacter("402");
        System.out.println(vendingMachine.pressDispenseProductButton());
    }
}
