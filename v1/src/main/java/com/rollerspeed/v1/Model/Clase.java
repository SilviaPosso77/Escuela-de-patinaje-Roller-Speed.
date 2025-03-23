package com.rollerspeed.v1.Model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="clase")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clase {
    @Id
    @Column(name = "IDCLASE", nullable = false, unique = true)
    private int IDclase;

    @Column(name="NOMBRECLASE", nullable = false, length = 100)
    private String NombreClase;

    @Column(name="FECHAINICIO", nullable = false)
    private Date FechaInicio;

    @Column(name="FECHAFINAL", nullable = false)
    private Date FechaFinal;

    @Column(name="HORARIO", nullable= false, length = 16)
    private String Horario;

    @Column(name="DIA", nullable= false, length = 16)
    private String Dia;

    @OneToMany(mappedBy = "clase")
    private List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "clase")
    private List<Profesor> profesores;

    
}
