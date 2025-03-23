package com.rollerspeed.v1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rollerspeed.v1.Model.Profesor;

import jakarta.transaction.Transactional;

@Repository
public interface HorariosProfesoresRepositorio extends JpaRepository<Profesor, Long>{
   
    @Modifying
    @Transactional
    @Query(value = "Create view horarios_profesores as"+
                " select profesores.id,profesores.nombre, profesores.apellido, clase.NOMBRECLASE,clase.HORARIO,clase.DIA" +
                " from profesores" +
                " join clase on profesores.id_clase = clase.IDCLASE", nativeQuery = true)
    void crearHorariosProfesores(); 
}
