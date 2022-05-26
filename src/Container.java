import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Container implements Serializable {
    LinkedList<ExitScore> scoreList;
    Container(){
        scoreList = new LinkedList<>();
    }
    void sort(){
        if(scoreList!=null){
            scoreList.sort((o1, o2) -> o1.rank>o2.rank?1:0);
        }
    }
}
