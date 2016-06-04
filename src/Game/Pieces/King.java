package Game.Pieces;

import Game.Board;
import Game.Square;

public class King extends Piece {

    public King(Board.Colour colour, Board board) {
        super(colour, board);
        value = 0;
        pieceType = PieceType.KING;
    }

    @Override
    protected void calculateValidMoves() {
        addValidMove(currentSquare.getX() + 1, currentSquare.getY());
        addValidMove(currentSquare.getX() + 1, currentSquare.getY() + 1);
        addValidMove(currentSquare.getX(), currentSquare.getY() + 1);
        addValidMove(currentSquare.getX() - 1, currentSquare.getY() + 1);
        addValidMove(currentSquare.getX() - 1, currentSquare.getY());
        addValidMove(currentSquare.getX() - 1, currentSquare.getY() - 1);
        addValidMove(currentSquare.getX(), currentSquare.getY() - 1);
        addValidMove(currentSquare.getX() + 1, currentSquare.getY() - 1);
    }

    private Boolean addValidMove(int x, int y) {
        if (board.isValidSquare(x, y) && board.getPieceTypeAtSquare(x, y) != colour) {
            addValidMove(x, y);
            return true;
        } else {
            return false;
        }
        //Todo: cannot move into check
    }
}
