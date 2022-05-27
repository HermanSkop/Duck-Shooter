import java.io.*;

public class GetFromFile {
    GetFromFile() {}

    Container getCont() {
        try {
        FileInputStream fis = new FileInputStream("stat_table");
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (Container) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
    int getPoints(){
        try {
            FileInputStream fis = new FileInputStream("points");
            return fis.read();
        } catch (IOException e) {
            return 0;
        }
    }
    int getDmg(){
        try {
            FileInputStream fis = new FileInputStream("dmg");
            return fis.read();
        } catch (IOException e) {
            return 0;
        }
    }
}
