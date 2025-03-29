package com.rollerspeed.v1.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class EstudianteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private int idClase;
    private String genero;

}
