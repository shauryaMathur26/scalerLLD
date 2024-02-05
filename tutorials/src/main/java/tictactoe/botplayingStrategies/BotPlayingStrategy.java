package tictactoe.botplayingStrategies;

import tictactoe.models.Board;
import tictactoe.models.Move;

public interface BotPlayingStrategy {

    public Move makeMove(Board board);
}
