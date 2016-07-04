package Game.Pieces;

import Game.Board;
import Game.Square;
import java.util.HashSet;

/**
 * Created by ajanthan on 2016-05-05.
 */
public class Pawn extends Piece {
    private boolean isBlocked;
    private boolean hasMoved;
    private boolean canCaptureByEnPesant;

    public Pawn(Board.Colour colour, Board board, Square initialSquare) {
        super(colour, board, initialSquare);
        value = 1;
        pieceType = PieceType.PAWN;
        isBlocked = false;
        hasMoved = false;
        canCaptureByEnPesant = false;
    }

    @Override
    protected void calculateValidMoves() {
        validMoves = new HashSet<>();
        int direction;
        Board.Colour enenmyColour;
        if(colour == Board.Colour.WHITE){
            direction = 1;
            enenmyColour = Board.Colour.BLACK;
        }else{
            direction = -1;
            enenmyColour = Board.Colour.WHITE;
        }
        // Can move up one
        if (board.isValidSquare(currentSquare.getX(), currentSquare.getY() + direction)
                && board.getPieceTypeAtSquare(currentSquare.getX(), currentSquare.getY() + direction) == Board.Colour.NONE) {
            validMoves.add(new Square(currentSquare.getX(), currentSquare.getY() + direction));
            isBlocked = false;
        } else {
            isBlocked = true;
        }
        // Capture Piece to front right
        if (board.isValidSquare(currentSquare.getX() + 1, currentSquare.getY() + direction) &&
                board.getPieceTypeAtSquare(currentSquare.getX() + direction, currentSquare.getY() + direction) == enenmyColour) {
            validMoves.add(new Square(currentSquare.getX() + direction, currentSquare.getY() + 1));
        }
        // Capture Piece to front left
        if (board.isValidSquare(currentSquare.getX() - 1, currentSquare.getY() + direction) &&
                board.getPieceTypeAtSquare(currentSquare.getX() - 1, currentSquare.getY() + direction) == enenmyColour) {
            validMoves.add(new Square(currentSquare.getX() - 1, currentSquare.getY() + direction));
        }
        if (!hasMoved && !isBlocked) {
            if (board.isValidSquare(currentSquare.getX(), currentSquare.getY() + 2*direction)
                    && board.getPieceTypeAtSquare(currentSquare.getX(), currentSquare.getY() + 2*direction) == Board.Colour.NONE) {
                validMoves.add(new Square(currentSquare.getX(), currentSquare.getY() + 2*direction));
            }
        }
        //Todo: implement en pesant
    }

    @Override
    public boolean move(Square end) {
        if(super.move(end)){
            hasMoved = true;
            return true;
        }
        return false;
    }
}
