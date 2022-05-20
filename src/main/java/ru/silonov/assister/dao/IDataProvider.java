package ru.silonov.assister.dao;

import java.util.Optional;

public interface IDataProvider {
    <T> boolean insert(T object);
    <T> Optional<T> getById(Class<T> tClass, int id);
    <T> boolean update(T object);
    <T> boolean delete(T object);
}
