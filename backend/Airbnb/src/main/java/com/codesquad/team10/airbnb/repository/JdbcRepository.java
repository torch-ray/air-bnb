package com.codesquad.team10.airbnb.repository;

import java.util.List;
import java.util.Optional;

public interface JdbcRepository<T> {
    Optional<T> findById(Long id);

    Optional<T> findById(String id);

    List<T> findAll();

    void add(T t);

    void update(T t);

    void delete(Long id);

    void delete(String id);
}
