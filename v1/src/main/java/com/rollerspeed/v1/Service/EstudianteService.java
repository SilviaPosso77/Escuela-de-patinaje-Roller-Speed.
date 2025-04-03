package com.rollerspeed.v1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rollerspeed.v1.Model.Estudiante;
import com.rollerspeed.v1.Repository.EstudianteRepository;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }
    
    public Estudiante ObtenerId(Long Id){
        return estudianteRepository.findById(Id).get();
    }

    public Estudiante ActualizarEstudiante(Estudiante datosAntiguos, Estudiante datosNuevos){
        datosAntiguos.setNombre(datosNuevos.getNombre());
        datosAntiguos.setApellido(datosNuevos.getApellido());
        datosAntiguos.setClase(datosNuevos.getClase());
        datosAntiguos.setGenero(datosNuevos.getGenero());
        datosAntiguos.setFechaNacimiento(datosNuevos.getFechaNacimiento());
        datosAntiguos.setId(datosNuevos.getId());
        return estudianteRepository.save(datosAntiguos);
    }

    public void EliminarEstudiante(Long id){
        estudianteRepository.deleteById(id);
    }
}
