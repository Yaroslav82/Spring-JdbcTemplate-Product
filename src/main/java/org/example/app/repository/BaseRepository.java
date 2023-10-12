package org.example.app.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    boolean create(T obj);
    Optional<List<T>> getAll();
    Optional<T> getById(Integer id);
    boolean update(T obj);
    boolean delete(T obj);
}
