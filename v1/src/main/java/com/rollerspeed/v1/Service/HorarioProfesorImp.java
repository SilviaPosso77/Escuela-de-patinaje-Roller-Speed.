package com.rollerspeed.v1.Service;

import com.rollerspeed.v1.Entity.HorarioProfesor;
import com.rollerspeed.v1.Repository.HorarioProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioProfesorImp implements HorarioProfesorServicio{

    @Autowired
    private HorarioProfesorRepositorio repositorio;

    @Override
    public List<HorarioProfesor> mostrarHorariosProfesores() {
        return(List<HorarioProfesor>) repositorio.findAll();
    }
}
