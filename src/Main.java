import Game.Board;
import Game.Square;

public class Main{

    public static void main(String[] args) {
        System.out.println("Begin Chess 9000");
        Board board = new Board();
        board.getPieceAtSquare(6,0).move(new Square(7,2));
        System.out.println(board.getPieceAtSquare(7,2).getValidMoves().toString());
    }

}

