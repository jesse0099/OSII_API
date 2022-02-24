package com.backend.api.service;

import java.util.List;

public interface IService <T> {
    List<T> get();
    T get(Long T);
    void delete(Long id);
    void create(T t);
}
