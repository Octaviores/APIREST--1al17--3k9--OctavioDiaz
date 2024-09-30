package com.example.apirest.services;

//Esta interface se declaran los métodos principales que necesitamos para
// realizar las 4 operaciones princiaples: GET, UPDATE, DELETE, SAVE (creo que son esos)

//Esta inteface se puede utilizar en cualquier servicio sin necesidad
// de declarar los métodos en cada uno

import com.example.apirest.entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.io.Serializable;
import java.util.List;
@Service
public interface BaseService<E extends Base, ID extends Serializable> {
    public List<E> findAll() throws Exception;
    public Page<E> findAll(Pageable pageable) throws  Exception;
    public E findById(ID Id) throws Exception;
    public E save (E entity) throws Exception;
    public E update (ID id, E entity) throws Exception;
    public boolean delete (ID id) throws Exception;

}
