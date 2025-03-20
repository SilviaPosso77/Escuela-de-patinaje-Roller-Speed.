package com.rollerspeed.v1.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rollerspeed.v1.Model.Estudiante;
import com.rollerspeed.v1.Repository.EstudianteRepository;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }
}
