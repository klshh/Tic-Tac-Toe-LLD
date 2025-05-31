package player;

import strategy.IPlayerStrategy;
import utils.PieceType;

public class Player {
    PieceType pieceType;
    IPlayerStrategy IPlayerStrategy;

    public Player(PieceType pieceType, IPlayerStrategy IPlayerStrategy) {
        this.pieceType = pieceType;
        this.IPlayerStrategy = IPlayerStrategy;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public IPlayerStrategy getPlayerStrategy() {
        return IPlayerStrategy;
    }
}
