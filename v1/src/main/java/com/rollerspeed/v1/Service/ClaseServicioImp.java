package com.rollerspeed.v1.Service;

import java.util.List;

import com.rollerspeed.v1.Entity.Clase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rollerspeed.v1.Repository.ClaseRepositorio;

@Service
public class ClaseServicioImp implements ClaseServicio {
    
    @Autowired
    private ClaseRepositorio repositorio;

    @Override
    public List<Clase> listarTodasLasClases(){

        return(List<Clase>) repositorio.findAll();
    }
}
