package com.rollerspeed.v1.Repository;

import com.rollerspeed.v1.Entity.HorarioEstudiante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioEstudianteRepositorio extends CrudRepository<HorarioEstudiante,Integer> {
}
