package com.vishal.vendingMachine;

import com.vishal.vendingMachine.enums.ItemType;
import com.vishal.vendingMachine.model.InputMethod;
import com.vishal.vendingMachine.model.Inventory;
import com.vishal.vendingMachine.model.Item;
import com.vishal.vendingMachine.model.State;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private static VendingMachine vendingMachine;

    private State currentState;
    private Inventory inventory;
    private InputMethod inputMethod;
    private int insertedCoins = 0;

    private VendingMachine(State state, InputMethod inputMethod) {
        setState(state);
        this.inputMethod = inputMethod;
        createInventory();
    }

    public synchronized static VendingMachine getInstance(State state, InputMethod inputMethod) {
        if (vendingMachine == null) {
            vendingMachine = new VendingMachine(state, inputMethod);
        }
        return vendingMachine;
    }

    public void setState(State newState) {
        currentState = newState;
    }

    private void createInventory() {
        Item i1 = new Item("Fanta", 104, 30, ItemType.BEVERAGE);
        Item i2 = new Item("Cadbury star", 109, 20, ItemType.CHOCOLATE);
        Item i3 = new Item("Mazza", 206, 35, ItemType.BEVERAGE);
        Item i4 = new Item("Lays chips", 402, 20, ItemType.CHIPS);
        Item i5 = new Item("Ice bell vanilla", 380, 30, ItemType.ICE_CREAM);

        List<Item> items = new ArrayList<>();
        items.add(i1);
        items.add(i2);
        items.add(i3);
        items.add(i4);
        items.add(i5);

        inventory = new Inventory(items);
    }

    public void insertInputCharacter(String character) {
        inputMethod.insertCharacter(character);
    }

    public String getInputCharacters() {
        return inputMethod.getInput();
    }

    public void clearInputData() {
        inputMethod.clearData();
    }

    public void setCoins(int coins) {
        insertedCoins = coins;
    }

    public int getInsertedCoins() {
        return insertedCoins;
    }

    public State getCurrentState() {
        return currentState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String pressAcceptCoinsButton() {
        return currentState.acceptCoinsButtonAction();
    }

    public String pressSelectProductButton() {
        return currentState.selectProductButtonAction();
    }

    public String pressDispenseProductButton() {
        return currentState.dispenseProductButtonAction();
    }

    public String pressCancelButton() {
        return currentState.cancelButtonAction();
    }
}
