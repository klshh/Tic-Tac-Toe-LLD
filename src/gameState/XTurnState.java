package gameState;

import player.Player;
import utils.PieceType;

public class XTurnState implements IGameState{
    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        if(hasWon){
            context.setGameState(player.getPieceType() == PieceType.X ? new XWinState() : new OWinState());
        } else {
            context.setGameState(new OTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
