package tictactoe.winningStrategies;

import tictactoe.models.Board;
import tictactoe.models.Move;
import tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy{

    Map<Integer, HashMap<Symbol,Integer>> colCount = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {

        // | 0 | -> {'X' -> 0, 'O' -> 2}
        // | 1 | -> {'X' -> 0, 'O' -> 2}
        // | 2 | -> {'X' -> 0, 'O' -> 2}

        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!colCount.containsKey(col)){
            colCount.put(col,new HashMap<>());
        }
        HashMap<Symbol,Integer> colMap = colCount.get(col);
        if(!colMap.containsKey(symbol)){
            colMap.put(symbol,0);
        }
        colMap.put(symbol,colMap.get(symbol)+1);

        if(colMap.get(symbol) == board.getSize())
            return true;
        return false;

    }

    @Override
    public void handleUndo(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        HashMap<Symbol,Integer> colMap = colCount.get(col);
        colMap.put(symbol,colMap.get(symbol)-1);
    }
}
