package com.rollerspeed.v1.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class ClaseDTO {
    private int IDclase;
    private String NombreClase;
    private Date FechaInicio;
    private Date FechaFinal;
    private String Horario;
    private String Dia;
}
