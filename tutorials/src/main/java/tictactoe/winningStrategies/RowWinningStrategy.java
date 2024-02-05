package tictactoe.winningStrategies;

import tictactoe.models.Board;
import tictactoe.models.Move;
import tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{

    Map<Integer, HashMap<Symbol,Integer>> rowCount = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) { //O(1)

        // | 0 | -> {'X' -> 0, 'O' -> 2}
        // | 1 | -> {'X' -> 0, 'O' -> 2}
        // | 2 | -> {'X' -> 0, 'O' -> 2}

        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!rowCount.containsKey(row)){
            rowCount.put(row,new HashMap<>());
        }
        HashMap<Symbol,Integer> rowMap = rowCount.get(row);
        if(!rowMap.containsKey(symbol)){
            rowMap.put(symbol,0);
        }
        rowMap.put(symbol,rowMap.get(symbol)+1);

        if(rowMap.get(symbol) == board.getSize())
            return true;
        return false;

    }

    @Override
    public void handleUndo(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();
        HashMap<Symbol,Integer> rowMap = rowCount.get(row);
        rowMap.put(symbol,rowMap.get(symbol)-1);
    }
}
