package tictactoe;

import tictactoe.controllers.GameController;
import tictactoe.enums.GameState;
import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.InvalidPlayerCountException;
import tictactoe.exceptions.InvalidBotCountException;
import tictactoe.models.Game;
import tictactoe.models.Player;
import tictactoe.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, DuplicateSymbolException, InvalidPlayerCountException {
        //Client -> Controller -> Models/Service
        GameController gameController = new GameController();
        System.out.println("Game starting...");

        try{
            // Client Inputs
            // Size, players,winningStrategies
            int dimensions = 3;

            List<Player> players = new ArrayList<>();
            List<WinningStrategy> winningStrategyList = new ArrayList<>();
            Game game = gameController.startGame(dimensions,players,winningStrategyList);


            gameController.displayBoard(game); // Stateless

            while (gameController.checkState(game).equals(GameState.IN_PROGRESS)){
                gameController.makeMove(game);
                gameController.displayBoard(game);
            }

            System.out.println("The Game is finished!");

            if(gameController.checkState(game).equals(GameState.WON)){
                System.out.println("The Winner is " + gameController.getWinner(game).getName());
            }else if(gameController.checkState(game).equals(GameState.DRAW)){
                System.out.println("Game has ended in a DRAW");
            }
        }
        catch(Exception e){
            throw e;
        }

    }

}
