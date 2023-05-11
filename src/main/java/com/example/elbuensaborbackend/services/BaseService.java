package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.entities.Base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base, ID extends Serializable> {
    public List<E> findAll() throws Exception;
    public E findById(ID id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(E entity, ID id) throws Exception;
    public boolean delete(ID id) throws Exception;

}