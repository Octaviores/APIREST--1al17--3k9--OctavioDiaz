package com.example.apirest.repositories;

//Esta interface separa la lógica de negocios y la lógica de la base de datos
//Esta itnerface se va a comunicar directamente con la base de datos

//JpaRepository brinda los métodos para acceder a la base de datos
//y querys prearmadas para hacer consultas en la base de datos

import com.example.apirest.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
