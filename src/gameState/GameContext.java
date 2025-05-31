package gameState;

import player.Player;

public class GameContext {

    private IGameState gameState;

    public GameContext() {
        this.gameState = new XTurnState();
    }

    public IGameState getGameState() {
        return gameState;
    }

    public void setGameState(IGameState gameState) {
        this.gameState = gameState;
    }

    public void next(Player player, boolean hasWon){
        gameState.next(this,player,hasWon);
    }

    public boolean isGameOver(){
        return gameState.isGameOver();
    }

    public IGameState getCurrentState() {
        return this.getGameState();
    }
}
