package com.rollerspeed.v1.Service;

import com.rollerspeed.v1.Entity.HorarioEstudiante;
import com.rollerspeed.v1.Repository.HorarioEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioEstudianteImp implements HorarioEstudianteServicio{
    @Autowired
    private HorarioEstudianteRepositorio repositorio;

    @Override
    public List<HorarioEstudiante> mostrarHorariosEstudiantes() {
        return(List<HorarioEstudiante>) repositorio.findAll();
    }
}
