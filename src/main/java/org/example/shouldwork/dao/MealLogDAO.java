package org.example.shouldwork.dao;

import org.example.shouldwork.dto.MealDTO;
import org.example.shouldwork.dto.ProfileDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MealLogDAO implements DAOInterface<MealDTO> {

    @Override
    public String add(List<MealDTO> mealLogs) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("mealLogs.dat", true))) {
            for (MealDTO mealLog : mealLogs) {
                output.writeObject(mealLog); // Serialize mealLog to file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Add success";
    }

    @Override
    public void save(MealDTO obj) {

    }

    @Override
    public MealDTO get(int id) {
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
    public List<MealDTO> getAll() {
        List<MealDTO> mealLogs = new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("mealLogs.dat"))) {
            Object obj;
            while ((obj = input.readObject()) != null) {
                mealLogs.add((MealDTO) obj); // Deserialize each mealLog
            }
        } catch (EOFException e) {
            // EOF reached, this is expected when reading from file
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return mealLogs;
    }

    @Override
    public void update(MealDTO obj) {

    }

    @Override
    public void delete(String id) {

    }
}


