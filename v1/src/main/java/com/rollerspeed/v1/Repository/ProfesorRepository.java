package com.rollerspeed.v1.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rollerspeed.v1.Model.Profesor;


@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
