package com.vishal.snakeAndLadder;

import com.vishal.snakeAndLadder.exceptions.GameOverException;
import com.vishal.snakeAndLadder.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Rahul"));
        players.add(new Player("Aman"));
        players.add(new Player(("Saurabh")));
        players.add(new Player("Kunal"));
        players.add(new Player("Rakesh"));

        Map<Integer, Integer> jumps = new HashMap<>();
        jumps.put(2, 11);
        jumps.put(9, 3);
        jumps.put(5, 15);
        jumps.put(13, 4);
        jumps.put(6, 10);

        SnakeAndLadderGame snakeAndLadderGame = SnakeAndLadderGame.getInstance(4, jumps, 2, players, 3);
        while (true) {
            try {
                snakeAndLadderGame.play();
            } catch (GameOverException exception) {
                System.out.println(exception.getMessage());
                return;
            }
        }
    }
}
