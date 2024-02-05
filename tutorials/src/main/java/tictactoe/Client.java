package tictactoe;

import tictactoe.controllers.GameController;
import tictactoe.enums.DifficultyLevel;
import tictactoe.enums.GameState;
import tictactoe.enums.PlayerType;
import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.InvalidPlayerCountException;
import tictactoe.exceptions.InvalidBotCountException;
import tictactoe.models.BotPlayer;
import tictactoe.models.Game;
import tictactoe.models.Player;
import tictactoe.models.Symbol;
import tictactoe.winningStrategies.ColWinningStrategy;
import tictactoe.winningStrategies.DiagonalWinningStrategy;
import tictactoe.winningStrategies.RowWinningStrategy;
import tictactoe.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, DuplicateSymbolException, InvalidPlayerCountException {
        Scanner scanner = new Scanner(System.in);
        //Client -> Controller -> Models/Service
        GameController gameController = new GameController();
        System.out.println("Game starting...");

        try{
            // Client Inputs
            // Size, players,winningStrategies
            int dimensions = 3;

            List<Player> players = new ArrayList<>();

            players.add(new Player(1,"Shaurya",new Symbol('X'), PlayerType.HUMAN));
            players.add(new BotPlayer(2,"GPT",new Symbol('O'),PlayerType.BOT, DifficultyLevel.EASY));

            List<WinningStrategy> winningStrategyList = Arrays.asList(
                    new RowWinningStrategy(),new ColWinningStrategy(),new DiagonalWinningStrategy()
            );
            Game game = gameController.startGame(dimensions,players,winningStrategyList);

            gameController.displayBoard(game); // Stateless

            while (gameController.checkState(game).equals(GameState.IN_PROGRESS)){
                gameController.makeMove(game);
                System.out.println("Do you want to UNDO (y/n)?");
                String undoAns = scanner.next();
                if(undoAns.equalsIgnoreCase("Y")){
                    gameController.undo(game);
                }
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
