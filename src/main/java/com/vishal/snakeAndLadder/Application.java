package com.vishal.snakeAndLadder;

import com.vishal.snakeAndLadder.exceptions.GameOverException;
import com.vishal.snakeAndLadder.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Rahul"));
        players.add(new Player("Aman"));
        players.add(new Player("Saurabh"));
        players.add(new Player("Kunal"));
        players.add(new Player("Rakesh"));

        SnakeAndLadderGame snakeAndLadderGame = SnakeAndLadderGame.getInstance(100, 2, 460, 600, players, 3);
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
