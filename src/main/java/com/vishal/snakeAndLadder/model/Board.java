package com.vishal.snakeAndLadder.model;

import java.util.Map;

public class Board {
    private int boardSize;
    private Map<Integer, Integer> jumps;

    public Board(int boardSize, Map<Integer, Integer> jumps) {
        this.boardSize = boardSize;
        this.jumps = jumps;
    }

    public boolean hasJump(int start) {
        return jumps.containsKey(start);
    }

    public int getJumpEnd(int start) {
        return jumps.get(start);
    }

    public int getBoardLastStep() {
        return boardSize * boardSize;
    }
}
