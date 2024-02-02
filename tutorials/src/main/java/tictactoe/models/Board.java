package tictactoe.models;

import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int dimension){
        this.size = dimension;
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
//                cell.display();
            }
            System.out.println();
        }
    }
}
