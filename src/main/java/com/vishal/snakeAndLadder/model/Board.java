package com.vishal.snakeAndLadder.model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private int boardSize;
    private Map<Integer, Integer> jumps;
    private int noOfSnakes;
    private int noOfLadders;

    public Board(int boardSize, int noOfSnakes, int noOfLadders) {
        this.boardSize = boardSize;
        this.noOfSnakes = noOfSnakes;
        this.noOfLadders = noOfLadders;

        makeSnakesAndLadder();
    }

    private void makeSnakesAndLadder() {
        jumps = new HashMap<>();
        int ladderCnt = 0, snakeCnt = 0;

        while (ladderCnt < noOfLadders || snakeCnt < noOfSnakes) {
            int start = ThreadLocalRandom.current().nextInt(1, getBoardLastStep() + 1);
            int end = ThreadLocalRandom.current().nextInt(1, getBoardLastStep() + 1);

            if (start < end && ladderCnt < noOfLadders) {
                ladderCnt++;
                jumps.put(start, end);
            } else if (start > end && snakeCnt < noOfSnakes) {
                snakeCnt++;
                jumps.put(start, end);
            }
        }
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
