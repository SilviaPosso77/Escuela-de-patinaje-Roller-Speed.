package com.rollerspeed.v1.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="horario_profesores")
public class HorarioProfesor {
    @Column(name = "NOMBRE", nullable = false)
    private String Nombre;

    @Column(name = "APELLIDOS", nullable = false)
    private String Apellidos;

    @Id
    @Column(name ="NOMBRECLASE", nullable = false)
    private  String NombreClase;

    @Column (name = "HORARIO", nullable = false)
    private String Horario;

    @Column (name = "DIA", nullable = false)
    private String Dia;

    public HorarioProfesor(String nombre, String nombreClase, String apellidos, String horario, String dia) {
        Nombre = nombre;
        NombreClase = nombreClase;
        Apellidos = apellidos;
        Horario = horario;
        Dia = dia;
    }

    public HorarioProfesor(){

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getNombreClase() {
        return NombreClase;
    }

    public void setNombreClase(String nombreClase) {
        NombreClase = nombreClase;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String dia) {
        Dia = dia;
    }
}
