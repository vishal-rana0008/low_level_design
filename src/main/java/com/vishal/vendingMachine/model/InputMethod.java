package com.vishal.vendingMachine.model;

public interface InputMethod {
    void insertCharacter(String character);
    String getInput();
    void clearData();
}
