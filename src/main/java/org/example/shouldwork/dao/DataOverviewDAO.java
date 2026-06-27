/*
package org.example.shouldwork.dao;


import org.example.shouldwork.dto.DataOverviewDTO;
import org.example.shouldwork.dto.ProfileDTO;
import org.example.shouldwork.utils.FileUtils;

import java.util.List;

public class DataOverviewDAO implements DAOInterface<DataOverviewDTO> {
    private final FileUtils<DataOverviewDTO> fileUtils = new FileUtils<>("profiles.dat");

    @Override
    public void save(DataOverviewDTO obj) {
        List<DataOverviewDTO> profiles = fileUtils.readFromFile();
        profiles.add(obj);
        fileUtils.writeToFile(profiles);
    }

    @Override
    public DataOverviewDTO get(int id) {
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
    public List<DataOverviewDTO> getAll() {
        return fileUtils.readFromFile();
    }

    @Override
    public void update(DataOverviewDTO obj) {
        List<DataOverviewDTO> profiles = fileUtils.readFromFile();
        profiles.removeIf(profile -> profile.getId() == obj.getId());
        profiles.add(obj);
        fileUtils.writeToFile(profiles);
    }

    @Override
    public void delete(String id) {
        List<DataOverviewDTO> profiles = fileUtils.readFromFile();
        profiles.removeIf(profile -> profile.getId() == id);
        fileUtils.writeToFile(profiles);
    }

    @Override
    public String add(List<DataOverviewDTO> obj) {
        return "";
    }
}


 */


