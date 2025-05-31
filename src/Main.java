import boardGames.TicTacToeGame;
import strategy.HumanPlayerStrategy;
import strategy.IPlayerStrategy;

public class Main {
    public static void main(String[] args) {
        IPlayerStrategy playerXStrategy = new HumanPlayerStrategy("Player X");
        IPlayerStrategy playerOStrategy = new HumanPlayerStrategy("Player Y");
        TicTacToeGame game = new TicTacToeGame(playerXStrategy, playerOStrategy, 3, 3);
        game.play();
    }
}