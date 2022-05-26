import java.io.*;

public class SaveToFile {
    SaveToFile(ExitScore obj) {
        Container cont = null;
        try {
            cont = new GetFromFile().getCont();
            if(cont!=null) {
                cont.scoreList.add(obj);
                for (Object i : cont.scoreList) System.out.println(i);

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
}
