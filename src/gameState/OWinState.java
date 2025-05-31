package gameState;

import player.Player;

public class OWinState implements IGameState{
    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
//        no need to go to next state as this is final state
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
