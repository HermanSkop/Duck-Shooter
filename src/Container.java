import java.io.Serializable;
import java.util.LinkedList;

public class Container implements Serializable {
    LinkedList<ExitScore> scoreList;
    Container(){
        scoreList = new LinkedList<>();
    }
}
