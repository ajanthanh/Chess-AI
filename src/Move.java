import javafx.scene.image.Image;
import javafx.util.Pair;

/**
 * Created by ajanthan on 2016-05-04.
 */
public class Move {
    private Pair<String,Integer> start;
    private Pair<String,Integer> destination;
    Move(String startX, int startY, String destinationX, int destinationY){
        this.start= new Pair<>(startX,startY);
        this.destination= new Pair<>(destinationX,destinationY);
    }
}
