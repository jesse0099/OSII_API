package com.backend.api.dao;

import java.util.List;

public interface IDao<T> {
    List<T> get();
    T get(Long id);
    void delete(Long id);
    void create(T t);
    void deleteByParam(String uniqueParam);
    boolean exists(String uniqueParam);
    int countByParam(String param);
    T objByUniqueParam(String uniqueParam);
}
