package org.example.app.service;

public interface BaseService<T> {
    String create(T obj);
    String getAll();
    String getById(String id);
    String update(T obj);
    String delete(String id);
}
