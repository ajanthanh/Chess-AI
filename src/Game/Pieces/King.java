package Game.Pieces;

import Game.Board;
import Game.Square;

import java.util.ArrayList;
import java.util.HashSet;

public class King extends Piece {

    public King(Board.Colour colour, Board board, Square initialSquare) {
        super(colour, board, initialSquare);
        value = 0;
        pieceType = PieceType.KING;
    }

    @Override
    protected void calculateValidMoves() {
        validMoves = new HashSet<>();
        addValidMove(currentSquare.getX() + 1, currentSquare.getY());
        addValidMove(currentSquare.getX() + 1, currentSquare.getY() + 1);
        addValidMove(currentSquare.getX(), currentSquare.getY() + 1);
        addValidMove(currentSquare.getX() - 1, currentSquare.getY() + 1);
        addValidMove(currentSquare.getX() - 1, currentSquare.getY());
        addValidMove(currentSquare.getX() - 1, currentSquare.getY() - 1);
        addValidMove(currentSquare.getX(), currentSquare.getY() - 1);
        addValidMove(currentSquare.getX() + 1, currentSquare.getY() - 1);
    }

    public boolean isCheck(Board.Colour colour, Square move){
        HashSet<Square> attackedSquares = new HashSet<>();
        ArrayList<Piece> enemyPieces;
        if(colour == Board.Colour.WHITE){
            enemyPieces = board.getBlackPieces();
        }else{
            enemyPieces = board.getWhitePieces();
        }
        for(Piece piece : enemyPieces){
            attackedSquares.addAll(piece.getValidMoves());
        }
        if(attackedSquares.contains(move)){
            return false;
        }else{
            return true;
        }
    }

    private Boolean addValidMove(int x, int y) {
        if (board.isValidSquare(x, y) && board.getPieceTypeAtSquare(x, y) != colour && isCheck(colour,new Square(x,y))) {
            validMoves.add(new Square(x, y));
            return true;
        } else {
            return false;
        }
        //Todo: cannot move into check
    }


}
