package Game.Pieces;

import Game.Board;
import Game.Square;
import Helper.ValidationHelper;

import java.util.HashSet;

public class Bishop extends Piece {
    private Boolean isBlocked;

    public Bishop(Board.Colour colour, Board board, Square initialSquare) {
        super(colour, board, initialSquare);
        value = 3;
        pieceType = PieceType.BISHOP;
        isBlocked = false;
    }

    @Override
    protected void calculateValidMoves() {
        validMoves = new HashSet<>();
        int i = 1;
        while (addValidMove(currentSquare.getX() + i, currentSquare.getY() + i)) {
            i++;
        }
        i = 1;
        while (addValidMove(currentSquare.getX() + i, currentSquare.getY() - i)) {
            i++;
        }
        i = 1;
        while (addValidMove(currentSquare.getX() - i, currentSquare.getY() + i)) {
            i++;
        }
        i = 1;
        while (addValidMove(currentSquare.getX() - i, currentSquare.getY() + i)) {
            i++;
        }
    }

    private Boolean addValidMove(int x, int y) {
        if (ValidationHelper.isValidSquare(x, y) && board.getPieceTypeAtSquare(x, y) != colour && !isBlocked) {
            validMoves.add(new Square(x, y));
            if (board.getPieceTypeAtSquare(x, y) == Board.Colour.WHITE || board.getPieceTypeAtSquare(x, y) == Board.Colour.BLACK) {
                isBlocked = true;
            }
            return true;
        } else {
            isBlocked = false;
            return false;
        }
    }
}
