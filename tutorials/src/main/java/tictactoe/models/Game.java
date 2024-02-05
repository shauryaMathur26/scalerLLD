package tictactoe.models;

import tictactoe.enums.CellState;
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

    public void printBoard(){
        board.printBoard();
    }

    public void makeMove(){

        //Find current player
        Player currentMovePlayer = players.get(nextMovePlayerIndex);
        System.out.println("It is " + currentMovePlayer.getName() + "'s move");

        //Make move
        Move move = currentMovePlayer.makeMove(board);

        if(!validateMove(move)){
            System.out.println("Invalid move! Please try again");
            return;
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToBeUpdated = board.getGrid().get(row).get(col);
        cellToBeUpdated.setPlayer(currentMovePlayer);
        cellToBeUpdated.setCellState(CellState.FILLED);

        //Add it to the moves list (Undo)
        Move finalMoveObject = new Move(cellToBeUpdated,currentMovePlayer);
        moves.add(finalMoveObject);

        // update nextMovePlayerIndex
        nextMovePlayerIndex += 1;
        nextMovePlayerIndex %= players.size(); // To handle circular nature of turns

        //update cell and board
        //check Winner and update game state

        if(checkWinner(board,finalMoveObject)){
           //Winner
            gameState = GameState.WON;
            winner = currentMovePlayer;
        }else if(moves.size() == board.getSize()* board.getSize()){
            //Draw
            gameState = GameState.DRAW;
        }

    }

    private boolean checkWinner(Board board, Move move){

        for(WinningStrategy winningStrategy : winningStrategies){
            if(winningStrategy.checkWinner(board,move)){
                return true;
            }
        }
        return false;
    }

    private boolean validateMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row >= board.getSize() || col >= board.getSize()){
            return false;
        }

        if(board.getGrid().get(row).get(col).getCellState().equals(CellState.EMPTY))
            return true;
        return false;
    }

    public void handleUndo(){
        //One move must be there
        if(moves.isEmpty()){
            System.out.println("No moves to UNDO");
            return;
        }
        // Get and remove last move
        Move move = moves.get(moves.size()-1);
        moves.remove(move);

        // Update cell state
        Cell cell = move.getCell();
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);

        // update nextPlayerIndex
        nextMovePlayerIndex -= 1;
        nextMovePlayerIndex = (nextMovePlayerIndex + players.size())% players.size();

        // Revert Winning Strategy maps
        for(WinningStrategy winningStrategy : winningStrategies){
            winningStrategy.handleUndo(board,move);
        }
    }
}