import java.io.*;

public class GetFromFile {
    GetFromFile() {}

    GetFromFile(ExitScore obj) throws IOException {
    }

    Container getCont() {
        try {
        FileInputStream fis = new FileInputStream("stat_table");
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (Container) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
