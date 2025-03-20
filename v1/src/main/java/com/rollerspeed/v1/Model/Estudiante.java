package com.rollerspeed.v1.Model;

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


    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private int edad;

    @Column(nullable = false)
    private String genero;
}
