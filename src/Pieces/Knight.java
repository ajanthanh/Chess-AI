package Pieces;

import Pieces.Piece;

public class Knight extends Piece {
    public Knight(Colour colour) {
        super(colour);
        value=3;
        pieceType = PieceType.KNIGHT;
    }
}
