package Game.Pieces;

import Game.Board;
import Game.Square;

import java.util.ArrayList;
import java.util.HashSet;

public class Knight extends Piece {

    public Knight(Board.Colour colour, Board board, Square initialSquare) {
        super(colour, board, initialSquare);
        value = 3;
        pieceType = PieceType.KNIGHT;
    }

    @Override
    protected void calculateValidMoves() {
        validMoves = new HashSet<>();
        addValidMove(currentSquare.getX() + 1, currentSquare.getY() + 2);
        addValidMove(currentSquare.getX() - 1, currentSquare.getY() + 2);
        addValidMove(currentSquare.getX() + 1, currentSquare.getY() - 2);
        addValidMove(currentSquare.getX() - 1, currentSquare.getY() - 2);
        addValidMove(currentSquare.getX() + 2, currentSquare.getY() + 1);
        addValidMove(currentSquare.getX() - 2, currentSquare.getY() + 1);
        addValidMove(currentSquare.getX() + 2, currentSquare.getY() - 1);
        addValidMove(currentSquare.getX() - 2, currentSquare.getY() - 1);
    }

    private void addValidMove(int x, int y) {
        if (board.isValidSquare(x, y) && board.getPieceTypeAtSquare(x, y) != colour) {
            validMoves.add(new Square(x, y));
        }
    }
}
