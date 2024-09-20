package com.example.apirest.services;

import com.example.apirest.entities.Persona;
import com.example.apirest.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements BaseService<Persona> {

  private PersonaRepository personaRepository;
//este constructor no se llama de ningún lado. Spring es el encargado de obtener las deependecias del servicio
//también se puede reemplazar el constructor con @Autowired
  public PersonaService (PersonaRepository personaRepository) {
      this.personaRepository = personaRepository;
  }

    @Override
    @Transactional
    public List<Persona> findAll() throws Exception {
        try{
            List<Persona> entities = personaRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long Id) throws Exception {

        try{
            //Usamos "Optional" porque no sabemos si encotraremos o no una entidad o registro con ese Id como clave primaria
            Optional<Persona> entityOptional = personaRepository.findById(Id);
            return entityOptional.get();
            // pongo "get()" porque retorna una entidad, sino larga error
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {

        try{

            entity = personaRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try{
            Optional<Persona> entityOptional = personaRepository.findById(id);
            Persona persona = entityOptional.get();
            persona = personaRepository.save(persona);
            return persona;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (personaRepository.existsById(id)){
                personaRepository.deleteById(id);
                return true;
            } else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
