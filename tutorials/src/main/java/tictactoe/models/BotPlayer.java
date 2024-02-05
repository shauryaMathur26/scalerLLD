package tictactoe.models;

import tictactoe.botplayingStrategies.BotPlayingStrategy;
import tictactoe.botplayingStrategies.BotPlayingStrategyFactory;
import tictactoe.enums.DifficultyLevel;
import tictactoe.enums.PlayerType;

public class BotPlayer extends Player{
    private DifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

   public BotPlayer(int id, String name, Symbol symbol, PlayerType playerType,DifficultyLevel difficultyLevel){
       super(id,name,symbol,playerType);
       this.difficultyLevel = difficultyLevel;
       this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyByDifficultyLevel(difficultyLevel); // Factory Pattern
   }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Move makeMove(Board board){
       Move move = botPlayingStrategy.makeMove(board);
       move.setPlayer(this);
       return move;
    }
}
