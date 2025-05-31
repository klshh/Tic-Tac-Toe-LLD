package boardGames;

import board.Board;
import gameState.GameContext;
import gameState.IGameState;
import gameState.OWinState;
import gameState.XWinState;
import player.Player;
import position.Position;
import strategy.IPlayerStrategy;
import utils.PieceType;

public class TicTacToeGame implements IBoardGames{

    private Board board;
    private Player xPlayer;
    private Player oPlayer;
    private Player currentPlayer;
    private GameContext gameContext;

    public TicTacToeGame(IPlayerStrategy xStrategy, IPlayerStrategy oStrategy,
                         int rows, int columns) {
        board = new Board(rows, columns);
        xPlayer = new Player(PieceType.X, xStrategy);
        oPlayer = new Player(PieceType.O, oStrategy);
        currentPlayer = xPlayer;
        gameContext = new GameContext();
    }

    @Override
    public void play() {
        do{
            board.printBoard();
            Position move = currentPlayer.getPlayerStrategy().makeMove(board);
            board.makeMove(move,currentPlayer.getPieceType());
            board.checkGameState(gameContext,currentPlayer);
            switchPlayer();
        }while (!gameContext.isGameOver());
        announceResult();
    }
    private void switchPlayer() {
        currentPlayer = (currentPlayer == xPlayer) ? oPlayer : xPlayer;
    }
    // Displays the outcome of the game based on the final game state.
    private void announceResult() {
        IGameState state = gameContext.getCurrentState();
        board.printBoard();
        if (state instanceof XWinState) {
            System.out.println("Player X wins!");
        } else if (state instanceof OWinState) {
            System.out.println("Player 0 wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
