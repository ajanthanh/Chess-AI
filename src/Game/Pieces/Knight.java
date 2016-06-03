package Game.Pieces;

import Game.Board;
import Game.Square;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Board.Colour colour, Board board) {
        super(colour, board);
        value = 3;
        pieceType = PieceType.KNIGHT;
    }

    @Override
    protected void calculateValidMoves() {
        validMoves = new ArrayList<>();
        addValidMove(square.getX()+1,square.getY()+2);
        addValidMove(square.getX()-1,square.getY()+2);
        addValidMove(square.getX()+1,square.getY()-2);
        addValidMove(square.getX()-1,square.getY()-2);
        addValidMove(square.getX()+2,square.getY()+1);
        addValidMove(square.getX()-2,square.getY()+1);
        addValidMove(square.getX()+2,square.getY()-1);
        addValidMove(square.getX()-2,square.getY()-1);
    }

    private void addValidMove(int x, int y){
        if(board.isValidSquare(x,y) && board.getPieceTypeAtSquare(x,y)!= colour){
            validMoves.add(new Square(x,y));
        }
    }
}
