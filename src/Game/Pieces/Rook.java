package Game.Pieces;

import Game.Board;

import java.util.ArrayList;

public class Rook extends Piece {
    private boolean isBlocked;

    public Rook(Board.Colour colour, Board board) {
        super(colour, board);
        value = 5;
        pieceType = PieceType.ROOK;
        isBlocked = false;
    }

    @Override
    protected void calculateValidMoves() {
        validMoves = new ArrayList<>();
        int i = 1;
        while (addValidMove(square.getX() + i, square.getY())) {
            i++;
        }
        i = 1;
        while (addValidMove(square.getX() - i, square.getY())) {
            i++;
        }
        i = 1;
        while (addValidMove(square.getX(), square.getY() + i)) {
            i++;
        }
        i = 1;
        while (addValidMove(square.getX(), square.getY() - i)) {
            i++;
        }

    }

    private Boolean addValidMove(int x, int y) {
        if (board.isValidSquare(x, y) && board.getPieceTypeAtSquare(x, y) != colour && !isBlocked) {
            addValidMove(x, y);
            if(board.getPieceTypeAtSquare(x,y)== Board.Colour.WHITE||board.getPieceTypeAtSquare(x,y)== Board.Colour.BLACK){
                isBlocked=true;
            }
            return true;
        } else {
            isBlocked=false;
            return false;
        }
    }
}
