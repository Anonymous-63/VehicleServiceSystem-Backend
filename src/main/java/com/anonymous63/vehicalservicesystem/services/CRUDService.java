package com.anonymous63.vehicalservicesystem.services;

import java.util.List;

public interface CRUDService<T> {

    T save(T entity);
    T update(T entity);
    void delete(Long id);
    T findById(Long id);
    List<T> findAll();
    List<T> disable();
    List<T> enable();

}
