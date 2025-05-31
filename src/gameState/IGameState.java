package gameState;

import player.Player;

public interface IGameState {
    void next(GameContext context, Player player, boolean hasWon);

    boolean isGameOver();
}
