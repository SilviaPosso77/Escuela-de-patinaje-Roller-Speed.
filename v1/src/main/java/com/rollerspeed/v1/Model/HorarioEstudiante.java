package com.rollerspeed.v1.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="horario_estudiantes")
public class HorarioEstudiante {
    @Id
    @Column(name = "Documento", nullable = false)
    private int Documento;

    @Column(name = "Nombres", nullable = false)
    private String Nombres;

    @Column(name = "Apellidos", nullable = false)
    private String Apellidos;

    @Column(name = "NOMBRECLASE", nullable = false)
    private String Clase;

    @Column(name = "Horario", nullable = false)
    private String Horario;

    @Column(name = "Dia", nullable = false)
    private String Dia;

    public HorarioEstudiante(int documento, String nombres, String apellidos, String clase, String horario, String dia) {
        Documento = documento;
        Nombres = nombres;
        Apellidos = apellidos;
        Clase = clase;
        Horario = horario;
        Dia = dia;
    }

    public HorarioEstudiante(){

    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public int getDocumento() {
        return Documento;
    }

    public void setDocumento(int documento) {
        Documento = documento;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getClase() {
        return Clase;
    }

    public void setClase(String clase) {
        Clase = clase;
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
