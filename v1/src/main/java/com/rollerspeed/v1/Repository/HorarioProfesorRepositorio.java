package com.rollerspeed.v1.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rollerspeed.v1.Model.HorarioProfesor;

@Repository
public interface HorarioProfesorRepositorio  extends CrudRepository <HorarioProfesor,String> {
}
