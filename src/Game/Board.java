package Game;

import Game.Pieces.*;

import java.awt.*;
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

    Board() {
        pieceAtSquare = new HashMap<>();
        pieceTypeAtSquare = new ArrayList<>();
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
        for (int y = 0; y < 8; y++) {
            ArrayList<Colour> row = new ArrayList<>();
            for (int x = 0; x < 8; x++) {
                if (y == 0 || y == 1) {
                    row.add(Colour.WHITE);
                }
                if (y == 6 || y == 7) {
                    row.add(Colour.BLACK);
                } else {
                    row.add(Colour.NONE);
                }
                pieceAtSquare.put(new Square(x, y), null);
            }
            pieceTypeAtSquare.add(row);
        }
        setBoard();
    }

    public Colour getPieceTypeAtSquare(int x, int y) {
        return pieceTypeAtSquare.get(y).get(x);
    }

    public Boolean isValidSquare(int x, int y) {
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            return true;
        } else {
            return false;
        }
    }
    public void movePiece(Square start, Square end, Colour colour){
        pieceAtSquare.put(end,pieceAtSquare.get(start));
        pieceAtSquare.remove(start);

        pieceTypeAtSquare.get(start.getY()).set(start.getX(),Colour.NONE);
        pieceTypeAtSquare.get(end.getY()).set(end.getX(),colour);
    }

    private void setBoard() {
        for (int x = 0; x < 8; x++) {
            Pawn pawn = new Pawn(Colour.WHITE, this);
            whitePieces.add(pawn);
            pieceAtSquare.put(new Square(x, 1), pawn);
            whitePieces.add(pawn);
        }
        Rook rook = new Rook(Colour.WHITE, this);
        whitePieces.add(rook);
        pieceAtSquare.put(new Square(0, 0), rook);
        whitePieces.add(rook);
        rook = new Rook(Colour.WHITE, this);
        whitePieces.add(rook);
        pieceAtSquare.put(new Square(7, 0), rook);
        whitePieces.add(rook);

        Knight knight = new Knight(Colour.WHITE, this);
        whitePieces.add(knight);
        pieceAtSquare.put(new Square(1, 0), knight);
        whitePieces.add(knight);
        knight = new Knight(Colour.WHITE, this);
        whitePieces.add(knight);
        pieceAtSquare.put(new Square(6, 0), knight);
        whitePieces.add(knight);

        Bishop bishop = new Bishop(Colour.WHITE, this);
        whitePieces.add(bishop);
        pieceAtSquare.put(new Square(2, 0), bishop);
        whitePieces.add(bishop);
        bishop = new Bishop(Colour.WHITE, this);
        whitePieces.add(bishop);
        pieceAtSquare.put(new Square(5, 0), bishop);
        whitePieces.add(bishop);

        Queen queen = new Queen(Colour.WHITE, this);
        whitePieces.add(queen);
        pieceAtSquare.put(new Square(3, 0), queen);
        whitePieces.add(queen);

        King king = new King(Colour.WHITE, this);
        whitePieces.add(king);
        pieceAtSquare.put(new Square(4, 0), king);
        whitePieces.add(king);

        for (int x = 0; x < 8; x++) {
            Pawn pawn = new Pawn(Colour.BLACK, this);
            whitePieces.add(pawn);
            pieceAtSquare.put(new Square(x, 6), pawn);
            blackPieces.add(pawn);
        }
        rook = new Rook(Colour.BLACK, this);
        pieceAtSquare.put(new Square(0, 7), rook);
        blackPieces.add(rook);
        rook = new Rook(Colour.BLACK, this);
        whitePieces.add(rook);
        pieceAtSquare.put(new Square(7, 7), rook);
        blackPieces.add(rook);

        knight = new Knight(Colour.BLACK, this);
        whitePieces.add(knight);
        pieceAtSquare.put(new Square(0, 0), knight);
        blackPieces.add(knight);
        knight = new Knight(Colour.BLACK, this);
        whitePieces.add(knight);
        pieceAtSquare.put(new Square(0, 0), knight);
        blackPieces.add(knight);

        bishop = new Bishop(Colour.BLACK, this);
        whitePieces.add(bishop);
        pieceAtSquare.put(new Square(2, 0), bishop);
        blackPieces.add(bishop);
        bishop = new Bishop(Colour.BLACK, this);
        whitePieces.add(bishop);
        pieceAtSquare.put(new Square(5, 0), bishop);
        blackPieces.add(bishop);

        queen = new Queen(Colour.BLACK, this);
        whitePieces.add(queen);
        pieceAtSquare.put(new Square(3, 0), queen);
        blackPieces.add(queen);

        king = new King(Colour.BLACK, this);
        whitePieces.add(king);
        pieceAtSquare.put(new Square(4, 0), king);
        blackPieces.add(king);
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
}