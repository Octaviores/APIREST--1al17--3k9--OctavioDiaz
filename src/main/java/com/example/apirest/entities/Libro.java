package com.example.apirest.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.List;


@Entity
@Table(name = "libro")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
public class Libro extends Base {

    @Column (name = "titulo")
    private String titulo;

    @Column (name = "fecha")
    private int fecha;

    @Column (name = "genero")
    private String genero;

    @Column (name = "paginas")
    private int paginas;

    //Usamos "CascadeType.REFRESH" porque al momento de persistir un libro, siempre se mantenga actualizados los autores.
    //Es decir, que si ocurrió un cambio en un "Autor", se va a actualizar para "Libro"
    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores;
}
