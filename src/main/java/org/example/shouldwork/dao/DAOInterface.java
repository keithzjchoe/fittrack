package org.example.shouldwork.dao;

import org.example.shouldwork.dto.ProfileDTO;

import java.util.List;

public interface DAOInterface<T> {
    void save(T obj);
    T get(int id);

    ProfileDTO get(String id);

    ProfileDTO getProfile();

    List<T> getAll();
    void update(T obj);
    void delete(String id);
    String add(List<T> obj);


}


