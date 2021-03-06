package Puzzles;

import Game.Board;
import Helper.PieceHelper;
import Helper.ValidationHelper;

import java.util.Scanner;

/**
 * Created by ajanthan on 2016-07-04.
 */
public class Puzzle {
    private Board board;
    private boolean isInputComplete;

    public Puzzle() {
        System.out.println("Puzzle Module");
        board = new Board(false);
        isInputComplete = false;
        setup();
    }

    private void setup() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter in pieces");
        //Todo exit upon reading "D"
        while (true) {
            String colourCode = reader.next();
            //Temporary Hack
            if(colourCode.toUpperCase().equals("D")){
                break;
            }
            String pieceCode = reader.next();
            int x = reader.nextInt();
            int y = reader.nextInt();
            if (ValidationHelper.isValidInput(colourCode, pieceCode, x, y) && ValidationHelper.isValidSquare(x, y)) {
                board.addPiece(PieceHelper.getColourFromCode(colourCode), PieceHelper.getPieceFromCode(pieceCode), x, y);
            }else{
                System.out.println("Invalid Piece Placement");
            }
        }
        System.out.println(board.toString());
    }

}
