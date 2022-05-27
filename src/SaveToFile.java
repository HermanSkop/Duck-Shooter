import java.io.*;

public class SaveToFile {
    SaveToFile(){}
    SaveToFile(ExitScore obj) {
        Container cont = null;
        try {
            cont = new GetFromFile().getCont();
            if(cont!=null) {
                cont.scoreList.add(obj);
                FileOutputStream fos = new FileOutputStream("stat_table");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(cont);
                oos.close();
            }
            else startFile(obj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    void startFile(ExitScore obj) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("stat_table");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Container cont = new Container();
        cont.scoreList.add(obj);
        oos.writeObject(cont);
        oos.close();
    }
    void savePointsToFile(int points) {
        int summ = 0;
        try {
            summ = new GetFromFile().getPoints()+points;
            FileOutputStream fos = new FileOutputStream("points");
            fos.write(summ);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void saveDmgToFile(int dmg) {
        try {
            FileOutputStream fos = new FileOutputStream("dmg");
            fos.write(dmg);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
