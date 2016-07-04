import Game.Board;
import Game.Square;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        System.out.println("Begin Chess 9000");
        Board board = new Board();
        while(true){
            try {
                Scanner reader = new Scanner(System.in);  // Reading from System.in
                System.out.println("eneter in Valid Move ");
                int x1 = reader.nextInt();
                int y1 = reader.nextInt();
                int x2 = reader.nextInt();
                int y2 = reader.nextInt();
                board.getPieceAtSquare(x1, y1).move(new Square(x2, y2));
                System.out.println(board.getPieceAtSquare(x2, y2).getCalculatedValidMoves().toString());
            }catch(Exception e){
                System.out.println("Invalid Move");
            }
        }
    }

}

