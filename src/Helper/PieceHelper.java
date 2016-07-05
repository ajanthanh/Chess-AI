package Helper;

import Game.Board;
import Game.Pieces.*;
import Game.Square;

/**
 * Created by ajanthan on 2016-07-04.
 */
public class PieceHelper {
    public static Piece.PieceType getPieceFromCode(String type) {
        if (type.toUpperCase().equals("K")) {
            return Piece.PieceType.KING;
        } else if (type.toUpperCase().equals("Q")) {
            return Piece.PieceType.QUEEN;
        } else if (type.toUpperCase().equals("R")) {
            return Piece.PieceType.ROOK;
        } else if (type.toUpperCase().equals("B")) {
            return Piece.PieceType.BISHOP;
        } else if (type.toUpperCase().equals("N")) {
            return Piece.PieceType.KNIGHT;
        } else if (type.toUpperCase().equals("P")) {
            return Piece.PieceType.PAWN;
        } else {
            return null;
        }
    }

    public static Board.Colour getColourFromCode(String c){
        if(c.toUpperCase().equals("W")){
            return Board.Colour.WHITE;
        }else if(c.toUpperCase().equals("B")){
            return Board.Colour.BLACK;
        }else {
            return null;
        }
    }

    public static Piece makePiece(Board.Colour colour, Piece.PieceType type, Board board, int x, int y){
        if(type == Piece.PieceType.KING){
            return new King(colour,board,new Square(x,y));
        }else if(type == Piece.PieceType.QUEEN){
            return new Queen(colour,board,new Square(x,y));
        }else if(type == Piece.PieceType.ROOK){
            return new Rook(colour,board,new Square(x,y));
        }else if(type == Piece.PieceType.BISHOP){
            return new Bishop(colour,board,new Square(x,y));
        }else if(type == Piece.PieceType.KNIGHT){
            return new Knight(colour,board,new Square(x,y));
        }else if(type == Piece.PieceType.PAWN){
            return new Pawn(colour,board,new Square(x,y));
        }else{
            return null;
        }
    }
}
