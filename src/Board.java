import Pieces.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ajanthan on 2016-05-05.
 */
public class Board {

    public enum squareType {WHITE, BLACK, NONE}
    private ArrayList<ArrayList<squareType>> coordiantes;
    private Map<Pair<Integer,Integer>,Piece> pieceLocation;
    private ArrayList<Piece> whitePieces;
    private ArrayList<Piece> blackPieces;

    Board(){
        pieceLocation = new HashMap<>();
        coordiantes = new ArrayList<>();
        for(int y=0;y<8;y++){
            ArrayList<squareType> row = new ArrayList<>();
            for(int x=0;x<8;x++){
                if(y==0||y==1){
                    row.add(squareType.WHITE);
                }
                if(y==6||y==7){
                    row.add(squareType.BLACK);
                }else {
                    row.add(squareType.NONE);
                }

                pieceLocation.put(new Pair<>(x,y),null);
            }
            coordiantes.add(row);
        }
        setBoard();
    }
    private void setBoard(){
        for(int x=0;x<8;x++){
            Pawn pawn = new Pawn(Piece.Colour.WHITE);
            whitePieces.add(pawn);
            pieceLocation.put(new Pair<>(x,1),pawn);
            whitePieces.add(pawn);
        }
        Rook rook = new Rook(Piece.Colour.WHITE);
        whitePieces.add(rook);
        pieceLocation.put(new Pair<>(0,0),rook);
        whitePieces.add(rook);
        rook = new Rook(Piece.Colour.WHITE);
        whitePieces.add(rook);
        pieceLocation.put(new Pair<>(7,0),rook);
        whitePieces.add(rook);

        Knight knight = new Knight(Piece.Colour.WHITE);
        whitePieces.add(knight);
        pieceLocation.put(new Pair<>(1,0),knight);
        whitePieces.add(knight);
        knight = new Knight(Piece.Colour.WHITE);
        whitePieces.add(knight);
        pieceLocation.put(new Pair<>(6,0),knight);
        whitePieces.add(knight);

        Bishop bishop = new Bishop(Piece.Colour.WHITE);
        whitePieces.add(bishop);
        pieceLocation.put(new Pair<>(2,0),bishop);
        whitePieces.add(bishop);
        bishop = new Bishop(Piece.Colour.WHITE);
        whitePieces.add(bishop);
        pieceLocation.put(new Pair<>(5,0),bishop);
        whitePieces.add(bishop);

        Queen queen = new Queen(Piece.Colour.WHITE);
        whitePieces.add(queen);
        pieceLocation.put(new Pair<>(3,0),queen);
        whitePieces.add(queen);

        King king = new King(Piece.Colour.WHITE);
        whitePieces.add(king);
        pieceLocation.put(new Pair<>(4,0),king);
        whitePieces.add(king);

        for(int x=0;x<8;x++){
            Pawn pawn = new Pawn(Piece.Colour.BLACK);
            whitePieces.add(pawn);
            pieceLocation.put(new Pair<>(x,6),pawn);
            blackPieces.add(pawn);
        }
        rook = new Rook(Piece.Colour.BLACK);
        pieceLocation.put(new Pair<>(0,7),rook);
        blackPieces.add(rook);
        rook = new Rook(Piece.Colour.BLACK);
        whitePieces.add(rook);
        pieceLocation.put(new Pair<>(7,7),rook);
        blackPieces.add(rook);

        knight = new Knight(Piece.Colour.BLACK);
        whitePieces.add(knight);
        pieceLocation.put(new Pair<>(0,0),knight);
        blackPieces.add(knight);
        knight = new Knight(Piece.Colour.BLACK);
        whitePieces.add(knight);
        pieceLocation.put(new Pair<>(0,0),knight);
        blackPieces.add(knight);

        bishop = new Bishop(Piece.Colour.BLACK);
        whitePieces.add(bishop);
        pieceLocation.put(new Pair<>(2,0),bishop);
        blackPieces.add(bishop);
        bishop = new Bishop(Piece.Colour.BLACK);
        whitePieces.add(bishop);
        pieceLocation.put(new Pair<>(5,0),bishop);
        blackPieces.add(bishop);

        queen = new Queen(Piece.Colour.BLACK);
        whitePieces.add(queen);
        pieceLocation.put(new Pair<>(3,0),queen);
        blackPieces.add(queen);

        king = new King(Piece.Colour.BLACK);
        whitePieces.add(king);
        pieceLocation.put(new Pair<>(4,0),king);
        blackPieces.add(king);
    }

    private int getScore(Piece.Colour colour){
        int sum =0;
        if(colour== Piece.Colour.WHITE){
            for(int i=0;i<whitePieces.size();i++){
                sum+=whitePieces.get(i).getValue();
            }
        }else if(colour== Piece.Colour.BLACK){
            for(int i=0;i<blackPieces.size();i++){
                sum+=blackPieces.get(i).getValue();
            }
        }
        return sum;
    }
}
