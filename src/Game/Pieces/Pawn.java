package Game.Pieces;

import Game.Board;
import Game.Square;

import java.util.ArrayList;

/**
 * Created by ajanthan on 2016-05-05.
 */
public class Pawn extends Piece {
    public Pawn(Board.Colour colour, Board board) {
        super(colour, board);
        value = 1;
        pieceType = PieceType.PAWN;
    }

    @Override
    protected void calculateValidMoves() {
        validMoves = new ArrayList<>();
        if (colour == Board.Colour.WHITE) {
            // Can move up one
            if (board.isValidSquare(square.getX(), square.getY() + 1)
                    && board.getPieceTypeAtSquare(square.getX(), square.getY() + 1) == Board.Colour.NONE) {
                validMoves.add(new Square(square.getX() + 1, square.getY()));
            }
            // Capture Piece to front right
            if (board.isValidSquare(square.getX() + 1, square.getY() + 1) &&
                    board.getPieceTypeAtSquare(square.getX() + 1, square.getY() + 1) == Board.Colour.BLACK) {
                validMoves.add(new Square(square.getX() + 1, square.getY() + 1));
            }
            // Capture Piece to front left
            if (board.isValidSquare(square.getX() - 1, square.getY() + 1) &&
                    board.getPieceTypeAtSquare(square.getX() - 1, square.getY() + 1) == Board.Colour.BLACK) {
                validMoves.add(new Square(square.getX() - 1, square.getY() + 1));
            }
            //Todo: implement en pesant
        }
    }
}
