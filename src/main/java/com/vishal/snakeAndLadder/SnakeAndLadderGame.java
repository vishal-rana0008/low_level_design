package com.vishal.snakeAndLadder;

import com.vishal.snakeAndLadder.exceptions.GameOverException;
import com.vishal.snakeAndLadder.model.Board;
import com.vishal.snakeAndLadder.model.Dice;
import com.vishal.snakeAndLadder.model.Player;

import java.util.*;

public class SnakeAndLadderGame {
    public static SnakeAndLadderGame snakeAndLadderGame;

    private Board board;
    private Dice dice;
    private Queue<Player> players;
    private List<Player> winners;
    private int noOfWinPlayersCondition;

    private SnakeAndLadderGame(int boardSize, int noOfDice, int noOfSnakes, int noOfLadders,
                               List<Player> players, int noOfWinPlayersCondition) {
        board = new Board(boardSize, noOfSnakes, noOfLadders);
        dice = new Dice(noOfDice);

        this.players = new LinkedList<>();
        this.players.addAll(players);

        this.noOfWinPlayersCondition = noOfWinPlayersCondition;

        this.winners = new ArrayList<>();
    }

    public static synchronized SnakeAndLadderGame getInstance(int boardSize, int noOfDice, int noOfSnakes, int noOfLadders,
                                                              List<Player> players, int noOfWinPlayersCondition) {
        if (snakeAndLadderGame == null) {
            snakeAndLadderGame = new SnakeAndLadderGame(boardSize, noOfDice, noOfSnakes, noOfLadders, players, noOfWinPlayersCondition);
        }
        return snakeAndLadderGame;
    }

    public void play() throws GameOverException {
        if (winners.size() == noOfWinPlayersCondition) {
            throw new GameOverException("Game is over. These are the first " + noOfWinPlayersCondition
                    + " players : " + winners);
        }

        Player player = players.remove();
        int currPosition = player.getCurrPosition();

        System.out.println("Player : " + player.getName() + " is playing, with current Position : " + currPosition);

        int stepsCnt = dice.rollDice();

        System.out.println("Dice rolled and gave number : " + stepsCnt);

        int newPosition = currPosition + stepsCnt;
        if (newPosition > board.getBoardLastStep()) {
            newPosition = board.getBoardLastStep();
        }

        if (board.hasJump(newPosition)) {
            if (board.getJumpEnd(newPosition) > newPosition) {
                System.out.println("Got a ladder from : " + newPosition + " to " + board.getJumpEnd(newPosition));
            } else {
                System.out.println("Bitten by a snake from : " + newPosition + " to " + board.getJumpEnd(newPosition));
            }
            newPosition = board.getJumpEnd(newPosition);
        }

        player.setCurrPosition(newPosition);

        if (newPosition == board.getBoardLastStep()) {
            System.out.println("Player reached destination !!");
            winners.add(player);
        } else {
            players.add(player);
        }

        System.out.println();
    }
}
