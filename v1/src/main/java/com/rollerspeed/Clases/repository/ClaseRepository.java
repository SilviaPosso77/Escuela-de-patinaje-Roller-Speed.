package com.rollerspeed.Clases.repository; // Paquete corregido

import com.rollerspeed.Clases.model.Clase; // Import corregido
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica que esta interfaz es un repositorio de Spring
public interface ClaseRepository extends JpaRepository<Clase, Long> {
    // No necesitas implementar métodos, Spring Data JPA lo hace por ti
}