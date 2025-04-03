package com.rollerspeed.v1.Service;

import java.util.List;

import com.rollerspeed.v1.Model.Clase;

public interface ClaseServicio {
    public List<Clase> listarTodasLasClases();
    public void registrarClase(Clase clase);
    public Clase ObtenerId(int Id);
    public Clase ActualizarClase(Clase datosAntiguos, Clase datosNuevos);

}

