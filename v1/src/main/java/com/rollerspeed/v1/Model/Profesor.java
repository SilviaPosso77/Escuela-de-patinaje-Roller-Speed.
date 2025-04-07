package com.rollerspeed.v1.Model;

import java.sql.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "profesores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Email
    @NotBlank
    private String email;

    @ManyToOne
    @JoinColumn(name = "idClase", referencedColumnName = "IDCLASE")
    private Clase clase;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private String genero;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
}
