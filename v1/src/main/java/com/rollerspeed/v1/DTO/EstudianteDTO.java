package com.rollerspeed.v1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {
    @NotNull
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    @Email
    private String email;
    @Past
    private Date fechaNacimiento;
    private int idClase;
    @NotBlank
    private String genero;
    private Set<String> roles;
    @NotBlank
    private String contraseña;

}
