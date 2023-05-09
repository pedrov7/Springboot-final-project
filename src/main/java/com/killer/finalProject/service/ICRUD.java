package com.killer.finalProject.service;

import com.killer.finalProject.model.Enrollment;

import java.util.List;
import java.util.Map;

public interface ICRUD<T,ID> {

    T save(T t) throws Exception;

    T update(T t,ID id) throws Exception;

    List<T> readAll() throws Exception;

    T readById(ID id) throws Exception;

    void delete(ID id) throws Exception;

}
