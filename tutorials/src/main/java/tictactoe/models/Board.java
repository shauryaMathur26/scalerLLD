package tictactoe.models;

import Interfaces.A;
import tictactoe.enums.CellState;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size){
        this.size = size;

        board = new ArrayList<>();

        for(int i=0;i<size;i++){
            board.add(new ArrayList<>());
            for(int j=0;j<size;j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getGrid() {
        return board;
    }

    public void setBoard(List<List<Cell>> grid) {
        this.board = grid;
    }

    public void printBoard(){
        for(List<Cell> row : board){
            for(Cell cell : row){
                // Display my Cell
                cell.display();
            }
            System.out.println();
        }
    }
}
