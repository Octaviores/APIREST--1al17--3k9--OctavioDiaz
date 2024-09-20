package com.example.apirest.controllers;

// Con "CrossOrigin" permitimos el acceso a la APi desde distintos orígenes (distintos clientes)
//con "ResquestMapping" creamos una URL para acceder a los métodos de una clase. En este caso, "Persona"

import com.example.apirest.entities.Persona;
import com.example.apirest.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaCotroller {

    private PersonaService personaService;

public PersonaCotroller(PersonaService personaService){
    this.personaService = personaService;
}
    // Este "GetMapping" indica el tipo de Request que queremos que se realize con el metodo "getAll".
    //Dentro indicamos la URI (path) específica de este metodo. Usamos las comillas básicas ""
    @GetMapping("")
//este "ResponseEntity" nos va a brindar los estados y respuestas en formato json para la aplicación web
public ResponseEntity<?> getAll(){
    try{
        //Este return tendrá el status de la respuesta (si salió bien o mal)
    return ResponseEntity.status(HttpStatus.OK).body(personaService.findAll());
    } catch (Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde\"}");

    }
}


    @GetMapping("/{id}")
public ResponseEntity<?> getOne(Long id){
    try{

        return ResponseEntity.status(HttpStatus.OK).body(personaService.findById(id));
    } catch (Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde\"}");

    }
}



@PostMapping("")
public ResponseEntity<?> save(@RequestBody Persona entity){
    try{

        return ResponseEntity.status(HttpStatus.OK).body(personaService.save(entity));
    } catch (Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor, intente más tarde\"}");

    }
}


@PutMapping("/{id}")
public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Persona entity){
    try{

        return ResponseEntity.status(HttpStatus.OK).body(personaService.update(id,entity));
    } catch (Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor, intente más tarde\"}");

    }
}


@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Long id){
        try{

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personaService.delete(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor, intente más tarde\"}");

        }
    }
}

