package Pieces;

/**
 * Created by ajanthan on 2016-05-05.
 */
public class Pawn extends Piece{
    public Pawn(Colour colour) {
        super(colour);
        value=1;
        pieceType = PieceType.PAWN;
    }
}
