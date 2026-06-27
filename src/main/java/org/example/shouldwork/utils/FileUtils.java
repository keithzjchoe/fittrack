package org.example.shouldwork.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils<T> {
    private final String filePath;

    public FileUtils(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(List<T> objects) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

