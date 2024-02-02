package tictactoe.models;

import tictactoe.enums.GameState;
import tictactoe.enums.PlayerType;
import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.InvalidPlayerCountException;
import tictactoe.exceptions.InvalidBotCountException;
import tictactoe.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board board;
    private List<Move> moves;
    private List<Player> players;
    private int nextMovePlayerIndex;
    private List<WinningStrategy> winningStrategies;
    private Player winner;
    private GameState gameState;

    private Game(int dimension,List<Player> players,List<WinningStrategy> winningStrategies){
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.players = players;
        this.nextMovePlayerIndex = 0;
        this.winningStrategies = winningStrategies;
        this.winner = null;
        this.gameState = GameState.IN_PROGRESS;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{

        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;


        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Game build() throws InvalidBotCountException,InvalidPlayerCountException,DuplicateSymbolException{

            //Validations

            // Bot Count
            validateBotCount();
            // Player Count
            validatePlayerCount();
            // No duplicate symbols
            validateDuplicateSymbols();

            return new Game(this.dimension,this.players,this.winningStrategies);
        }

        private void validateDuplicateSymbols() throws DuplicateSymbolException{
            HashSet<Symbol> set = new HashSet<>();
            for(Player player : players){
                if(set.contains(player.getSymbol())){
                    throw new DuplicateSymbolException();
                }
                set.add(player.getSymbol());

            }
        }

        private void validateBotCount() throws InvalidBotCountException {
            int botCount = 0;
            for(Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT))
                    botCount ++;
            }
            if(botCount>1){
                throw new InvalidBotCountException();
            }
        }

        private void validatePlayerCount() throws InvalidPlayerCountException{
            if(players.size() > dimension-1)
                throw new InvalidPlayerCountException();
        }

    }

    public Board getBoard() {
        return board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }
}
