package com.rollerspeed.v1.Model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estudiantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "idClase", referencedColumnName = "IDCLASE")
    private Clase clase;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private String genero;


}
