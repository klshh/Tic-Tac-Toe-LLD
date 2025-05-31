package board;

import gameState.GameContext;
import player.Player;
import position.Position;
import utils.PieceType;

public class Board {

    private final int rows;
    private final int columns;
    private PieceType[][] grid;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new PieceType[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = PieceType.EMPTY;
            }
        }
    }
    public boolean isValid(Position move) {
        return move.getRow() >= 0 && move.getColumn() >= 0 && move.getRow() < rows && move.getColumn() < columns && grid[move.getRow()][move.getColumn()] == PieceType.EMPTY;
    }

    public void makeMove(Position pos, PieceType symbol) {
        grid[pos.getRow()][pos.getColumn()] = symbol;
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                PieceType symbol = grid[i][j];
                switch (symbol) {
                    case X:
                        System.out.print(" X ");
                        break;
                    case O:
                        System.out.print(" O ");
                        break;
                    case EMPTY:
                    default:
                        System.out.print(" . ");
                }

                if (j < columns - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < rows - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    public void checkGameState(GameContext context,Player currentPlayer){
//        check for row
        for(int i = 0; i< rows; i++){
            if(grid[i][0] != PieceType.EMPTY && isWinningLine(grid[i])){
                context.next(currentPlayer,true);
                return;
            }
        }

//        check for column
        for (int i = 0; i < columns; i++) {
            PieceType[] column = new PieceType[rows];
            for (int j = 0; j < rows; j++) {
                column[j] = grid[j][i];
            }
            if (column[0] != PieceType.EMPTY && isWinningLine(column)) {
                context.next(currentPlayer, true);
                return;
            }
        }

//        check for both diagonal
        PieceType[] diagonal1 = new PieceType[rows];
        PieceType[] diagonal2 = new PieceType[rows];

        for (int i = 0; i < Math.min(rows, columns); i++) {
            diagonal1[i] = grid[i][i];
            diagonal2[i] = grid[i][columns - 1 - i];
        }
        if (diagonal1[0] != PieceType.EMPTY && isWinningLine(diagonal1)) {
            context.next(currentPlayer, true);
            return;
        }
        if (diagonal2[0] != PieceType.EMPTY && isWinningLine(diagonal2)) {
            context.next(currentPlayer, true);
            return;
        }
    }

    private boolean isWinningLine(PieceType[] winningLine) {
        PieceType first = winningLine[0];
        for (PieceType s : winningLine) {
            if (s != first) {
                return false;
            }
        }
        return true;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public PieceType[][] getGrid() {
        return grid;
    }
}
