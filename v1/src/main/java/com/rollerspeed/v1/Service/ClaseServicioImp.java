package com.rollerspeed.v1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rollerspeed.v1.Model.Clase;
import com.rollerspeed.v1.Repository.ClaseRepositorio;

@Service
public class ClaseServicioImp implements ClaseServicio {
    
    @Autowired
    private ClaseRepositorio repositorio;

    @Override
    public List<Clase> listarTodasLasClases(){

        return(List<Clase>) repositorio.findAll();
    }

    @Override
    public void registrarClase(Clase clase){
        repositorio.save(clase);
    }

    @Override
    public Clase ObtenerId(int id){
        return repositorio.findById(id).get();
    }

    @Override
    public Clase ActualizarClase(Clase datosAntiguos, Clase datosNuevos){
        datosAntiguos.setNombreClase(datosNuevos.getNombreClase());
        datosAntiguos.setFechaFinal(datosNuevos.getFechaFinal());
        datosAntiguos.setFechaInicio(datosNuevos.getFechaInicio());
        datosAntiguos.setHorario(datosNuevos.getHorario());
        datosAntiguos.setDia(datosNuevos.getDia());
        return repositorio.save(datosAntiguos);
    }
}
