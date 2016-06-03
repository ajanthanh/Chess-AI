package Game;

import javafx.util.Pair;

/**
 * Created by ajanthan on 2016-06-01.
 */
public class Square {
    private Pair<Integer,Integer> square;
    public Square(int a, int b){
        square = new Pair<>(a,b);
    }
    public int getX(){
        return square.getKey();
    }
    public int getY(){
        return square.getValue();
    }
}
