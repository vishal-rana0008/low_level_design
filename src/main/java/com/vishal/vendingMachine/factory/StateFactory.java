package com.vishal.vendingMachine.factory;

import com.vishal.vendingMachine.VendingMachine;
import com.vishal.vendingMachine.enums.StateType;
import com.vishal.vendingMachine.model.State;
import com.vishal.vendingMachine.model.impl.ConsumingCoinsState;
import com.vishal.vendingMachine.model.impl.IdleState;
import com.vishal.vendingMachine.model.impl.ProductSelectionState;

public class StateFactory {

    private static final ConsumingCoinsState consumingCoinsState = new ConsumingCoinsState(null);
    private static final ProductSelectionState productSelectionState = new ProductSelectionState(null);

    public static State createState(StateType stateType, VendingMachine vendingMachine) {
        switch (stateType) {
            case IDLE_STATE:
                return new IdleState(vendingMachine);
            case CONSUMING_COINS_STATE:
                consumingCoinsState.setVendingMachine(vendingMachine);
                return consumingCoinsState;
            case PRODUCT_SELECTION_STATE:
                productSelectionState.setVendingMachine(vendingMachine);
                return productSelectionState;
            default:
                return null;
        }
    }
}
