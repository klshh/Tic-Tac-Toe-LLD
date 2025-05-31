package strategy;

import board.Board;
import position.Position;

import java.util.Scanner;

public class HumanPlayerStrategy implements IPlayerStrategy{

    private Scanner scanner;
    private String playerName;

    public HumanPlayerStrategy(String playerName) {
        this.scanner = new Scanner(System.in);
        this.playerName = playerName;
    }

    @Override
    public Position makeMove(Board board) {
        while (true){
            System.out.printf(
                    "%s, enter your move (row [0-2] and column [0-2]): ", playerName);
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                Position move = new Position(row, col);

                if(board.isValid(move)){
                    return move;
                }
                System.out.println("Invalid move. Try again.");
            } catch (Exception e){
                System.out.println("Invalid Move Please Try Again Later");
                scanner.nextLine();
            }
        }
    }
}
