package com.rollerspeed.v1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rollerspeed.v1.Model.Profesor;
import com.rollerspeed.v1.Repository.ProfesorRepository;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

     public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    public void registrarProfesor(Profesor profesor) {
        profesorRepository.save(profesor);
    }

    public Profesor ObtenerId(Long Id){
        return profesorRepository.findById(Id).get();
    }

    public Profesor ActualizarProfesor(Profesor datosAntiguos, Profesor datosNuevos){
        datosAntiguos.setNombre(datosNuevos.getNombre());
        datosAntiguos.setApellido(datosNuevos.getApellido());
        datosAntiguos.setClase(datosNuevos.getClase());
        datosAntiguos.setGenero(datosNuevos.getGenero());
        datosAntiguos.setFechaNacimiento(datosNuevos.getFechaNacimiento());
        datosAntiguos.setId(datosNuevos.getId());
        return profesorRepository.save(datosAntiguos);
    }

    public void EliminarProfesor(Long id){
        profesorRepository.deleteById(id);
    }
}