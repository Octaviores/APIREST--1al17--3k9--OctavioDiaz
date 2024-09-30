package com.example.apirest.controllers;

import com.example.apirest.entities.Base;
import com.example.apirest.entities.Persona;
import com.example.apirest.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;


public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E,Long>> implements BaseController<E, Long> {
    @Autowired
    protected S servicio;

    // Este "GetMapping" indica el tipo de Request que queremos que se realize con el metodo "getAll".
    //Dentro indicamos la URI (path) específica de este metodo. Usamos las comillas básicas ""
    @GetMapping("")
//este "ResponseEntity" nos va a brindar los estados y respuestas en formato json para la aplicación web
    public ResponseEntity<?> getAll(){
        try{
            //Este return tendrá el status de la respuesta (si salió bien o mal)
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde\"}");

        }
    }
    @GetMapping("/paged")
    public ResponseEntity<?> getAll(Pageable pageable){
        try{

            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde\"}");

        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(Long id){
        try{

            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde\"}");

        }
    }



    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity){
        try{

            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor, intente más tarde\"}");

        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity){
        try{

            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id,entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor, intente más tarde\"}");

        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Long id){
        try{

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor, intente más tarde\"}");

        }
    }
}
