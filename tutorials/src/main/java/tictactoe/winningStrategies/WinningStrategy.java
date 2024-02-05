package tictactoe.winningStrategies;

import tictactoe.models.Board;
import tictactoe.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);

    void handleUndo(Board board, Move move);
}
