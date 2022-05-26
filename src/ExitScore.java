import java.io.Serializable;

public class ExitScore implements Serializable {
    String name;
    int score;
    int time;
    int difflvl;
    float rank;

    ExitScore(String name, int Score, int Time, int diffLvl){
        this.name = name;
        score = Score;
        time = Time;
        difflvl = diffLvl;

        rank = (float)Score*diffLvl/2;
    }

    @Override
    public String toString() {
        return "ExitScore{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", time=" + time +
                ", difflvl=" + difflvl +
                ", rank=" + rank +
                '}';
    }
}
