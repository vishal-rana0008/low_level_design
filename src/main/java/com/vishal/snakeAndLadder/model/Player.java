package com.vishal.snakeAndLadder.model;

import java.util.concurrent.ThreadLocalRandom;

public class Player {
    private int id;
    private String name;
    private int currPosition;

    public Player(String name) {
        id = ThreadLocalRandom.current().nextInt();
        currPosition = 1;
        this.name = name;
    }

    public int getCurrPosition() {
        return currPosition;
    }

    public void setCurrPosition(int currPosition) {
        this.currPosition = currPosition;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currPosition=" + currPosition +
                '}';
    }
}
