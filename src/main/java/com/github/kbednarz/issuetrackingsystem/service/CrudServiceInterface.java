package com.github.kbednarz.issuetrackingsystem.service;

import java.util.List;

public interface CrudServiceInterface<T, U> {
    T save(U instance);

    T get(Long id);

    List<T> listAll();
}
