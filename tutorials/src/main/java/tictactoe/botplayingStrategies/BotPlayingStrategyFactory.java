package tictactoe.botplayingStrategies;

import tictactoe.enums.DifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyByDifficultyLevel(DifficultyLevel difficultyLevel){
        if(DifficultyLevel.EASY.equals(difficultyLevel)){
            return new EasyBotPlayingStrategy(); // Strategy Pattern
        }
        return null;
    }
}
