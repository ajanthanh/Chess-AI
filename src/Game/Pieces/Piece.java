package Game.Pieces;

import Game.Board;
import Game.Square;

import java.util.*;

/**
 * Created by ajanthan on 2016-05-04.
 */
public abstract class Piece {

    public enum PieceType {PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING}

    protected int value;
    protected Board.Colour colour;
    protected PieceType pieceType;
    protected Board board;
    protected Square currentSquare;

    protected HashSet<Square> validMoves;

    protected abstract void calculateValidMoves();

    Piece(Board.Colour colour, Board board, Square initialSquare) {
        this.colour = colour;
        this.board = board;
        this.validMoves = new HashSet<>();
        this.currentSquare = initialSquare;
    }

    public int getValue() {
        return value;
    }

    public Board.Colour getColour() {
        return colour;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public HashSet<Square> getCalculatedValidMoves() {
        calculateValidMoves();
        return validMoves;
    }

    public HashSet<Square> getValidMoves(){
        return validMoves;
    }

    public boolean move(Square end) {
        calculateValidMoves();
        if (!isValid(end)) {
            return false;
        }
        board.movePiece(this.currentSquare, end, colour);
        this.currentSquare = end;
        return true;
    }

    protected Boolean isValid(Square move) {
        if(validMoves.contains(move)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format(pieceType + " : " + currentSquare.getX() + ", " + currentSquare.getY());
    }
}
