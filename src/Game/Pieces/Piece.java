package Game.Pieces;
import Game.Board;
import Game.Move;
import Game.Square;

import java.util.ArrayList;

/**
 * Created by ajanthan on 2016-05-04.
 */
public abstract class Piece {

//    public enum Colour {WHITE, BLACK}

    public enum PieceType {PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING}

    protected int value;
    protected Board.Colour colour;
    protected PieceType pieceType;
    protected Board board;
    protected Square square;

    protected ArrayList<Square> validMoves;

    protected abstract void calculateValidMoves();

    Piece(Board.Colour colour, Board board) {
        this.colour = colour;
        this.board = board;
        this.validMoves = new ArrayList<>();
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

    public void move(Square square){
        if(isValid(square)){
            this.square =square;
        }
    }

    public ArrayList<Square> getValidMoves(){
        calculateValidMoves();
        return validMoves;
    }

    private Boolean isValid(Square move){
        for(int i =0;i<validMoves.size();i++){
            if(move==validMoves.get(i)){
                return true;
            }
        }
        return false;
    }
}
