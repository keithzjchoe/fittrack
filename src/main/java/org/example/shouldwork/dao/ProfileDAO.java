package org.example.shouldwork.dao;

import org.example.shouldwork.dto.ProfileDTO;
import org.example.shouldwork.utils.FileUtils;

import java.util.List;
import java.util.Objects;

public class ProfileDAO implements DAOInterface<ProfileDTO> {
    private final FileUtils<ProfileDTO> fileUtils = new FileUtils<>("profiles.dat");

    @Override
    public void save(ProfileDTO obj) {
        List<ProfileDTO> profiles = fileUtils.readFromFile();
        profiles.add(obj);
        fileUtils.writeToFile(profiles);
    }

    @Override
    public ProfileDTO get(int id) {
        return null;
    }

    @Override
    public ProfileDTO get(String id) {
        return fileUtils.readFromFile().stream()
                .filter(profile -> Objects.equals(profile.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public ProfileDTO getProfile(){

        return null;
    }

    @Override
    public List<ProfileDTO> getAll() {
        return fileUtils.readFromFile();
    }

    @Override
    public void update(ProfileDTO obj) {
        List<ProfileDTO> profiles = fileUtils.readFromFile();
        profiles.removeIf(profile -> Objects.equals(profile.getId(), obj.getId()));
        profiles.add(obj);
        fileUtils.writeToFile(profiles);
    }

    @Override
    public void delete(String id) {
        List<ProfileDTO> profiles = fileUtils.readFromFile();
        profiles.removeIf(profile -> Objects.equals(profile.getId(), id));
        fileUtils.writeToFile(profiles);
    }

    @Override
    public String add(List<ProfileDTO> obj) {
        return "";
    }
}



