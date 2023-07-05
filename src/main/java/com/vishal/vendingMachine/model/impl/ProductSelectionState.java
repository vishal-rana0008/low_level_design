package com.vishal.vendingMachine.model.impl;

import com.vishal.vendingMachine.VendingMachine;
import com.vishal.vendingMachine.enums.StateType;
import com.vishal.vendingMachine.factory.StateFactory;
import com.vishal.vendingMachine.model.Item;
import com.vishal.vendingMachine.model.State;

import java.util.Objects;

public class ProductSelectionState extends State {

    public ProductSelectionState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public String acceptCoinsButtonAction() {
        return "Invalid Input : Select product !!";
    }

    @Override
    public String selectProductButtonAction() {
        return "";
    }

    @Override
    public String dispenseProductButtonAction() {
        int itemCode = Integer.parseInt(vendingMachine.getInputCharacters());

        Item selectedItem = vendingMachine.getInventory().getItems().stream()
                .filter(item -> item.getItemCode() == itemCode)
                .findFirst().orElse(null);

        if (Objects.nonNull(selectedItem) && vendingMachine.getInsertedCoins() >= selectedItem.getPrice()) {
            vendingMachine.getInventory().removeItem(selectedItem.getItemCode());
            String outputStr = "Product dispensed";
            if (vendingMachine.getInsertedCoins() > selectedItem.getPrice()) {
                outputStr += ", Also pls collect your change coins : "
                        + (vendingMachine.getInsertedCoins() - selectedItem.getPrice());
            }
            vendingMachine.setState(StateFactory.createState(StateType.IDLE_STATE, vendingMachine));
            return outputStr;
        } else if (Objects.isNull(selectedItem)) {
            return "Invalid Input : Pls enter valid item code !!";
        } else {
            vendingMachine.setState(StateFactory.createState(StateType.IDLE_STATE, vendingMachine));
            return "Error : Insufficient money inserted, pls collect your inserted coins !!";
        }
    }

    @Override
    public String cancelButtonAction() {
        vendingMachine.setState(StateFactory.createState(StateType.IDLE_STATE, vendingMachine));
        return "If you had inserted coins, then pls collect them";
    }
}
