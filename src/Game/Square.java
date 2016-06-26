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
    public int hashCode(){
        return square.getKey()*10 + square.getValue();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Square){
            Square s = (Square)obj;
            if(s.getX()==getX()&&s.getY()==getY()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("("+getX()+","+getY()+")");
    }
}
