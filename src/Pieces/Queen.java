package Pieces;

public class Queen extends Piece {
    public Queen(Colour colour) {
        super(colour);
        value=9;
        pieceType = PieceType.QUEEN;
    }
}
