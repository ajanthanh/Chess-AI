package Game.Pieces;

import Game.Board;

public class King extends Piece {

    public King(Board.Colour colour, Board board) {
        super(colour, board);
        value=0;
        pieceType = PieceType.KING;
    }

    @Override
    protected void calculateValidMoves() {
        addValidMove(square.getX()+1,square.getY());
        addValidMove(square.getX()+1,square.getY()+1);
        addValidMove(square.getX(),square.getY()+1);
        addValidMove(square.getX()-1,square.getY()+1);
        addValidMove(square.getX()-1,square.getY());
        addValidMove(square.getX()-1,square.getY()-1);
        addValidMove(square.getX(),square.getY()-1);
        addValidMove(square.getX()+1,square.getY()-1);
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
