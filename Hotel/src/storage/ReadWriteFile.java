package storage;

import Model.Client;

import java.io.*;
import java.util.List;

public class ReadWriteFile {
    public static File file = new File("client1.dat");
    public static void writeToFile(List<Client> clients) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(clients);
            oos.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Client> readFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            return (List<Client> )ois.readObject();

    }
}