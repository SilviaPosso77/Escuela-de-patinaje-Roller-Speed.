package com.rollerspeed.v1.Repository;

import com.rollerspeed.v1.Entity.HorarioProfesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioProfesorRepositorio  extends CrudRepository <HorarioProfesor,String> {
}
