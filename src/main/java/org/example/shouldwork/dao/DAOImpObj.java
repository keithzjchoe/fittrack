/*
package org.example.shouldwork.dao;

import org.example.shouldwork.dto.ProfileDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DAOImpObj<T> implements DAOInterface<T> {
    private final String filePath;

    public DAOImpObj(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String add(List<T> objects) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filePath, false))) {
            for (T obj : objects) {
                output.writeObject(obj);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return "Add failed: " + ex.getMessage();
        }
        return "Add success";
    }

    @Override
    public T getObj(int id) {
        boolean found = false;
        T obj = null;

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    obj = (T) input.readObject();
                    if (obj instanceof User && ((User) obj).getId() == id) { // Replace `User` with your generic ID check logic if needed
                        found = true;
                        break;
                    }
                } catch (EOFException eof) {
                    break; // End of file reached
                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return found ? obj : null;
    }

    @Override
    public void save(T obj) {

    }

    @Override
    public T get(int id) {
        return null;
    }

    @Override
    public ProfileDTO get(String id) {
        return null;
    }

    @Override
    public ProfileDTO getProfile() {
        return null;
    }

    @Override
    public List<T> getAll() {
        List<T> objects = new ArrayList<>();

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    T obj = (T) input.readObject();
                    objects.add(obj);
                } catch (EOFException eof) {
                    break; // End of file reached
                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objects;
    }

    @Override
    public void update(T obj) {

    }

    @Override
    public void delete(String id) {

    }
}

 */

