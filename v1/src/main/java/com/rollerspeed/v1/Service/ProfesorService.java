package com.rollerspeed.v1.Service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.rollerspeed.v1.Model.Profesor;
import com.rollerspeed.v1.Repository.ProfesorRepository;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

     public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    public void registrarProfesor(Profesor profesor) {
        profesorRepository.save(profesor);
    }
}