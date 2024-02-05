package tictactoe.models;

import tictactoe.enums.PlayerType;

import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private Symbol symbol;
    //private boolean isBot;//GOOD IDEA? -- BAD IDEA
    private PlayerType playerType;

    private Scanner scanner;

    public Player(int id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = new Scanner((System.in));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        System.out.println("Enter the row - ");
        int row = scanner.nextInt();
        System.out.println("Enter the col - ");
        int col = scanner.nextInt();

        return new Move(new Cell(row,col),this);
    }
}
