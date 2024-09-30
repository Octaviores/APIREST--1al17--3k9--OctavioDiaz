package com.example.apirest.controllers;


// Con "CrossOrigin" permitimos el acceso a la APi desde distintos orígenes (distintos clientes)
//con "ResquestMapping" creamos una URL para acceder a los métodos de una clase. En este caso, "Persona"

import com.example.apirest.entities.Autor;
import com.example.apirest.services.AutorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl> {



}