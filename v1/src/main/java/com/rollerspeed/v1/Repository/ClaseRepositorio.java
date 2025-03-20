package com.rollerspeed.v1.Repository;

import com.rollerspeed.v1.Entity.Clase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepositorio extends CrudRepository<Clase, Integer>{

    
} 
