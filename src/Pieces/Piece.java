package Pieces;

import java.util.ArrayList;

/**
 * Created by ajanthan on 2016-05-04.
 */
public class Piece {
    public enum Colour {WHITE, BLACK}
    public enum PieceType {PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING}

    protected int value;
    protected Colour colour;
    protected PieceType pieceType;

    Piece(Colour colour){
        this.colour=colour;
    }

    public int getValue() {
        return value;
    }

    public Colour getColour() {
        return colour;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
