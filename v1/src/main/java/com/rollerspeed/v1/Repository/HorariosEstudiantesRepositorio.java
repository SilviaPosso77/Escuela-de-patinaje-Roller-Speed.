package com.rollerspeed.v1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rollerspeed.v1.Model.Estudiante;
import java.util.List;


@Repository
public interface HorariosEstudiantesRepositorio extends JpaRepository<Estudiante, Integer>{
    @Query(value = "Create view horarios_estudiantes as"+
                " select estudiantes.id,estudiantes.nombre, estudiantes.apellido, clase.NOMBRECLASE,clase.HORARIO,clase.DIA" +
                " from estudiantes" +
                " join clase on estudiantes.id_clase = clase.IDCLASE", nativeQuery = true)
    void crearHorariosEstudiantes();
}
