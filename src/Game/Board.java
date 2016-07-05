package Game;

import Game.Pieces.*;
import Helper.PieceHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ajanthan on 2016-05-05.
 */
public class Board {

    public enum Colour {WHITE, BLACK, NONE}

    private ArrayList<ArrayList<Colour>> pieceTypeAtSquare;
    private Map<Square, Piece> pieceAtSquare;
    private ArrayList<Piece> whitePieces;
    private ArrayList<Piece> blackPieces;

    public Board(boolean setupDefault) {
        pieceAtSquare = new HashMap<>();
        pieceTypeAtSquare = new ArrayList<>();
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
        if(setupDefault) {
            setDefaultBoard();
        }else{
            setupBlank();
        }
    }

    public Colour getPieceTypeAtSquare(int x, int y) {
        if(x>=0 && x<=7 &&y>=0&&y<=7) {
            return pieceTypeAtSquare.get(y).get(x);
        }else{
            System.out.println("invalid move");
            return null;
        }
    }

    public Piece getPieceAtSquare(int x, int y) {
        return pieceAtSquare.get(new Square(x, y));
    }

    public ArrayList<Piece> getWhitePieces(){
        return whitePieces;
    }

    public ArrayList<Piece> getBlackPieces(){
        return blackPieces;
    }

    public void movePiece(Square start, Square end, Colour colour) {
        pieceAtSquare.put(end, pieceAtSquare.get(start));
        pieceAtSquare.remove(start);

        pieceTypeAtSquare.get(start.getY()).set(start.getX(), Colour.NONE);
        pieceTypeAtSquare.get(end.getY()).set(end.getX(), colour);
    }

    private void setupBlank() {
        for (int y = 0; y < 8; y++) {
            ArrayList<Colour> row = new ArrayList<>();
            for (int x = 0; x < 8; x++) {
                row.add(Colour.NONE);
                pieceAtSquare.put(new Square(x, y), null);
            }
            pieceTypeAtSquare.add(row);
        }
    }

    private void setDefaultBoard() {
        for (int y = 0; y < 8; y++) {
            ArrayList<Colour> row = new ArrayList<>();
            for (int x = 0; x < 8; x++) {
                if (y == 0 || y == 1) {
                    row.add(Colour.WHITE);
                } else if (y == 6 || y == 7) {
                    row.add(Colour.BLACK);
                } else {
                    row.add(Colour.NONE);
                }
                pieceAtSquare.put(new Square(x, y), null);
            }
            pieceTypeAtSquare.add(row);
        }

        for (int x = 0; x < 8; x++) {
            Pawn pawn = new Pawn(Colour.WHITE, this, new Square(x, 1));
            pieceAtSquare.put(new Square(x, 1), pawn);
            whitePieces.add(pawn);
        }
        Rook rook = new Rook(Colour.WHITE, this, new Square(0, 0));
        whitePieces.add(rook);
        pieceAtSquare.put(new Square(0, 0), rook);
        rook = new Rook(Colour.WHITE, this, new Square(7, 0));
        pieceAtSquare.put(new Square(7, 0), rook);
        whitePieces.add(rook);

        Knight knight = new Knight(Colour.WHITE, this, new Square(1, 0));
        whitePieces.add(knight);
        pieceAtSquare.put(new Square(1, 0), knight);
        knight = new Knight(Colour.WHITE, this, new Square(6, 0));
        pieceAtSquare.put(new Square(6, 0), knight);
        whitePieces.add(knight);

        Bishop bishop = new Bishop(Colour.WHITE, this, new Square(2, 0));
        pieceAtSquare.put(new Square(2, 0), bishop);
        whitePieces.add(bishop);
        bishop = new Bishop(Colour.WHITE, this, new Square(5, 0));
        pieceAtSquare.put(new Square(5, 0), bishop);
        whitePieces.add(bishop);

        Queen queen = new Queen(Colour.WHITE, this, new Square(3, 0));
        pieceAtSquare.put(new Square(3, 0), queen);
        whitePieces.add(queen);

        King king = new King(Colour.WHITE, this, new Square(4, 0));
        pieceAtSquare.put(new Square(4, 0), king);
        whitePieces.add(king);

        for (int x = 0; x < 8; x++) {
            Pawn pawn = new Pawn(Colour.BLACK, this, new Square(x, 6));
            pieceAtSquare.put(new Square(x, 6), pawn);
            blackPieces.add(pawn);
        }
        rook = new Rook(Colour.BLACK, this, new Square(0, 7));
        pieceAtSquare.put(new Square(0, 7), rook);
        blackPieces.add(rook);
        rook = new Rook(Colour.BLACK, this, new Square(7, 7));
        pieceAtSquare.put(new Square(7, 7), rook);
        blackPieces.add(rook);

        knight = new Knight(Colour.BLACK, this, new Square(1, 7));
        pieceAtSquare.put(new Square(1, 7), knight);
        blackPieces.add(knight);
        knight = new Knight(Colour.BLACK, this, new Square(6, 7));
        pieceAtSquare.put(new Square(6, 7), knight);
        blackPieces.add(knight);

        bishop = new Bishop(Colour.BLACK, this, new Square(2, 7));
        pieceAtSquare.put(new Square(2, 7), bishop);
        blackPieces.add(bishop);
        bishop = new Bishop(Colour.BLACK, this, new Square(5, 7));
        pieceAtSquare.put(new Square(5, 7), bishop);
        blackPieces.add(bishop);

        queen = new Queen(Colour.BLACK, this, new Square(3, 7));
        pieceAtSquare.put(new Square(3, 7), queen);
        blackPieces.add(queen);

        king = new King(Colour.BLACK, this, new Square(4, 7));
        pieceAtSquare.put(new Square(4, 7), king);
        blackPieces.add(king);
    }

    public void addPiece(Colour colour, Piece.PieceType type, int x , int y){
        Piece piece = PieceHelper.makePiece(colour,type,this,x,y);
        pieceAtSquare.put(new Square(x,y),piece);
        pieceTypeAtSquare.get(y).set(x,colour);
        if(colour == Colour.BLACK){
            blackPieces.add(piece);
        }else{
            whitePieces.add(piece);
        }
    }

    private int getScore(Colour colour) {
        int sum = 0;
        if (colour == Colour.WHITE) {
            for (int i = 0; i < whitePieces.size(); i++) {
                sum += whitePieces.get(i).getValue();
            }
        } else if (colour == Colour.BLACK) {
            for (int i = 0; i < blackPieces.size(); i++) {
                sum += blackPieces.get(i).getValue();
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        for(int y=7;y>=0;y--){
            for(int x=0;x<8;x++){
                if(pieceTypeAtSquare.get(y).get(x)==Colour.NONE){
                    System.out.print("-- ");
                }else{
                    System.out.print(pieceAtSquare.get(new Square(x,y)).toString()+" ");
                }
            }
            System.out.println("");
        }
        return "";
    }
}
