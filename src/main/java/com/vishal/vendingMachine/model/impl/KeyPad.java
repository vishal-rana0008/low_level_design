package com.vishal.vendingMachine.model.impl;

import com.vishal.vendingMachine.model.InputMethod;

public class KeyPad implements InputMethod {

    private String inputString = "";

    @Override
    public void insertCharacter(String character) {
        inputString += character;
    }

    @Override
    public String getInput() {
        return inputString;
    }

    @Override
    public void clearData() {
        inputString = "";
    }
}
