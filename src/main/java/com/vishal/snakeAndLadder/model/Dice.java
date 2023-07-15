package com.vishal.snakeAndLadder.model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int noOfDices;

    public Dice(int noOfDices) {
        this.noOfDices = noOfDices;
    }

    public int rollDice() {
        int totalSum = 0;
        for (int i = 1; i <= noOfDices; i++) {
            totalSum += ThreadLocalRandom.current().nextInt(6) + 1;
        }
        return totalSum;
    }
}
