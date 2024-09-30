package com.example.apirest.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "persona")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
public class Persona extends Base {

    @Column(name = "nombre")
    private String nombre;

    @Column (name = "apellido")
    private String apellido;

    @Column (name="dni")
    private int dni;

    //Usamos "CascadeType.ALL" porque asi podemos hacer la persistencia, la actualización y eliminación a través de la misma persona
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;


    //Usamos "orphanRemoval = true" para que al eliminar una persona, se eliminan todos los libro asociados
    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "persona_libro",
            joinColumns = @JoinColumn(name = "pk_persona"),
            inverseJoinColumns = @JoinColumn (name ="pk_libro")
    )
    private List<Libro> libros = new ArrayList<Libro>();
}
