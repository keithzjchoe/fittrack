
package org.example.shouldwork.dao;

import org.example.shouldwork.dto.ProfileDTO;
import org.example.shouldwork.dto.WorkoutDTO;
import org.example.shouldwork.utils.FileUtils;

import java.util.List;
import java.util.Objects;

public class WorkoutLogDAO implements DAOInterface<WorkoutDTO> {
    private final FileUtils<WorkoutDTO> fileUtils = new FileUtils<>("workoutLogs.dat");

    @Override
    public void save(WorkoutDTO obj) {
        List<WorkoutDTO> profiles = fileUtils.readFromFile();
        profiles.add(obj);
        fileUtils.writeToFile(profiles);
    }

    @Override
    public WorkoutDTO get(int id) {
        return fileUtils.readFromFile().stream()
                .filter(profile -> profile.getId() == id)
                .findFirst()
                .orElse(null);
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
    public List<WorkoutDTO> getAll() {
        return fileUtils.readFromFile();
    }

    @Override
    public void update(WorkoutDTO obj) {
        List<WorkoutDTO> profiles = fileUtils.readFromFile();
        profiles.removeIf(profile -> Objects.equals(profile.getRoutineName(), obj.getRoutineName()));
        profiles.add(obj);
        fileUtils.writeToFile(profiles);
    }

    @Override
    public void delete(String id) {
        List<WorkoutDTO> profiles = fileUtils.readFromFile();
        profiles.removeIf(profile -> Objects.equals(profile.getRoutineName(), id));

        fileUtils.writeToFile(profiles);
    }

    @Override
    public String add(List<WorkoutDTO> obj) {
        return "";
    }
}



