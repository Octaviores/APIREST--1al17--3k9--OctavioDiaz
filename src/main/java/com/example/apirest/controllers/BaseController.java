package com.example.apirest.controllers;

import com.example.apirest.entities.Base;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

public interface BaseController <E extends Base, ID extends Serializable> {
   //el signo "?" en ResponseEntity, recibe cuaquier tipo que  extienda de Object. Sirve de Comodin
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getAll(Pageable pageable);
    public ResponseEntity<?> getOne(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody E entity);
    public ResponseEntity<?> update (@PathVariable ID id, @RequestBody E entity);
    public ResponseEntity<?> delete (@PathVariable ID id);
}
