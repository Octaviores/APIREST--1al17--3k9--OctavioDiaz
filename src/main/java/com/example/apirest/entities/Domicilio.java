package com.example.apirest.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;



@Entity
@Table(name = "domicilio")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
public class Domicilio extends Base {

    @Column (name = "calle")
    private String calle;

    @Column (name = "numero")
    private int numero;


    //se ponne "optional = false" porque, siempre que quiera crear una Persona, el domiclio debe tener una localidad
    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;
}
