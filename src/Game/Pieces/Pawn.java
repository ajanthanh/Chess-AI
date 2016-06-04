package Game.Pieces;

import Game.Board;
import Game.Square;

import java.util.ArrayList;

/**
 * Created by ajanthan on 2016-05-05.
 */
public class Pawn extends Piece {
    private boolean isBlocked;
    private boolean hasMoved;
    private boolean canCaptureByEnPesant;

    public Pawn(Board.Colour colour, Board board) {
        super(colour, board);
        value = 1;
        pieceType = PieceType.PAWN;
        isBlocked = false;
        hasMoved = false;
        canCaptureByEnPesant = false;
    }

    @Override
    protected void calculateValidMoves() {
        validMoves = new ArrayList<>();
        if (colour == Board.Colour.WHITE) {
            // Can move up one
            if (board.isValidSquare(currentSquare.getX(), currentSquare.getY() + 1)
                    && board.getPieceTypeAtSquare(currentSquare.getX(), currentSquare.getY() + 1) == Board.Colour.NONE) {
                validMoves.add(new Square(currentSquare.getX(), currentSquare.getY() + 1));
                isBlocked = false;
            } else {
                isBlocked = true;
            }
            // Capture Piece to front right
            if (board.isValidSquare(currentSquare.getX() + 1, currentSquare.getY() + 1) &&
                    board.getPieceTypeAtSquare(currentSquare.getX() + 1, currentSquare.getY() + 1) == Board.Colour.BLACK) {
                validMoves.add(new Square(currentSquare.getX() + 1, currentSquare.getY() + 1));
            }
            // Capture Piece to front left
            if (board.isValidSquare(currentSquare.getX() - 1, currentSquare.getY() + 1) &&
                    board.getPieceTypeAtSquare(currentSquare.getX() - 1, currentSquare.getY() + 1) == Board.Colour.BLACK) {
                validMoves.add(new Square(currentSquare.getX() - 1, currentSquare.getY() + 1));
            }
            if (!hasMoved && !isBlocked) {
                if (board.isValidSquare(currentSquare.getX(), currentSquare.getY() + 2)
                        && board.getPieceTypeAtSquare(currentSquare.getX(), currentSquare.getY() + 2) == Board.Colour.NONE) {
                    validMoves.add(new Square(currentSquare.getX(), currentSquare.getY() + 2));
                }
            }
            //Todo: implement en pesant
            //Todo: implement move two moves on first turn
        }
    }

}
