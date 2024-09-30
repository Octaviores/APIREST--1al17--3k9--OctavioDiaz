package com.example.apirest.entities;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.envers.Audited;



@Entity
@Table(name = "localidad")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
public class Localidad extends Base {

    @Column(name = "denominacion")
    private String denominacion;


}