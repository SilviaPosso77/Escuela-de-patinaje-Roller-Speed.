package com.rollerspeed.Clases.model;

public class Clase {
    private String nombre;
    private String horario;
    private String nivel;

    // Constructor, getters y setters
    public Clase(String nombre, String horario, String nivel) {
        this.nombre = nombre;
        this.horario = horario;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}