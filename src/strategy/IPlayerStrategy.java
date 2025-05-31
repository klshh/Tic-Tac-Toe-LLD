package strategy;


import board.Board;
import position.Position;

public interface IPlayerStrategy {
// Why Strategy?
//    Scalable -> integrate ai bot to play as AIPlayerStrategy and HumanPlayerStrategy
    Position makeMove(Board board);
}
