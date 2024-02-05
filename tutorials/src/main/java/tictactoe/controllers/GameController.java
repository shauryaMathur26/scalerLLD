package tictactoe.controllers;

import tictactoe.enums.GameState;
import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.InvalidPlayerCountException;
import tictactoe.exceptions.InvalidBotCountException;
import tictactoe.models.Game;
import tictactoe.models.Player;
import tictactoe.winningStrategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int size, List<Player> players, List<WinningStrategy> winningStrategies) throws InvalidBotCountException, DuplicateSymbolException, InvalidPlayerCountException {

        //BUILDER PATTERN
        return Game.getBuilder()
                .setDimension(size)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void displayBoard(Game game){
        game.printBoard();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void undo(Game game){
        game.handleUndo();
    }


    // 1. Create new game
    // 2. Display the board
    // Check winner and While the gameState is IN_PROGRESS
        // 3. Make a move
        // 4. Display updated board

    // Check game state and :
        // If draw -> handle draw
        // If winner -> display winner

    // Handle Undo

}
