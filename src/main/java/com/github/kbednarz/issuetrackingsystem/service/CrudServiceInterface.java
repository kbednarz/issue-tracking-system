package com.github.kbednarz.issuetrackingsystem.service;

import java.util.List;

public interface CrudServiceInterface<T> {
    T save(T instance);

    T get(Long id);

    List<T> listAll();
}
