package com.example.apirest.services;

//Esta interface se declaran los métodos principales que necesitamos para
// realizar las 4 operaciones princiaples: GET, UPDATE, DELETE, SAVE (creo que son esos)

//Esta inteface se puede utilizar en cualquier servicio sin necesidad
// de declarar los métodos en cada uno

import java.util.List;

public interface BaseService<E> {
    public List<E> findAll() throws Exception;
    public E findById(Long Id) throws Exception;
    public E save (E entity) throws Exception;
    public E update (Long id, E entity) throws Exception;
    public boolean delete (Long id) throws Exception;

}
