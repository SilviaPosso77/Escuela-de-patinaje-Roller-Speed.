package com.rollerspeed.v1.Model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profesores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;


    @Column(nullable = false, unique = true)
    private String idClase;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private String genero;
}
