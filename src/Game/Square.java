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
        int y = getY()+1;
        return String.format("("+getAlphaX()+","+y+")");
    }

    private String getAlphaX(){
        switch (getX()){
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:
                return "G";
            case 7:
                return "H";
            default:
                return "";
        }
    }
}
