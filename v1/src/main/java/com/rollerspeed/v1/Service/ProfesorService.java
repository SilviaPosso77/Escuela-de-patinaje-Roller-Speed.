package com.rollerspeed.v1.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rollerspeed.v1.Model.ERole;
import com.rollerspeed.v1.Model.Profesor;
import com.rollerspeed.v1.Model.RolEntity;
import com.rollerspeed.v1.Model.UserEntity;
import com.rollerspeed.v1.Repository.ProfesorRepository;
import com.rollerspeed.v1.Repository.RoleRespositorio;
import com.rollerspeed.v1.Repository.UserRespositorio;

import jakarta.transaction.Transactional;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private UserRespositorio userRespositorio;

    @Autowired
    private RoleRespositorio roleRespositorio;

     public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    public void registrarProfesor(Profesor profesor) {
        profesorRepository.save(profesor);
    }

    @Transactional
    public Profesor crearProfesor(Profesor profesor, String contraseña){
        //Crea el usuario
        UserEntity user = UserEntity.builder()
                        .username(profesor.getEmail()) //Asigna el email como nombre de usuario
                        .password(contraseña)
                        .roles(obtenerRol())
                        .build();
        userRespositorio.save(user); //Guarda el usuario
        profesor.setUser(user); //Relaciona el usuario con el profesor
        Profesor nuevoProfesor = profesorRepository.save(profesor); //Guarda el profesor
        return nuevoProfesor; 
    }

    private Set<RolEntity> obtenerRol(){
        //Logica para asignar el rol de Profesor
        RolEntity rolEstudiante = roleRespositorio.findByName(ERole.PROFESOR)
        .orElseThrow(()-> new RuntimeException("Rol PROFESOR no encontrado")); //En caso de que el Rol Estudiante no exista
        Set<RolEntity> roles = new HashSet<>();
        roles.add(rolEstudiante);
        return roles;
    }

    public Profesor ObtenerId(Long Id){
        return profesorRepository.findById(Id).get();
    }

    public Profesor ActualizarProfesor(Profesor datosAntiguos, Profesor datosNuevos){
        datosAntiguos.setNombre(datosNuevos.getNombre());
        datosAntiguos.setApellido(datosNuevos.getApellido());
        datosAntiguos.setClase(datosNuevos.getClase());
        datosAntiguos.setGenero(datosNuevos.getGenero());
        datosAntiguos.setFechaNacimiento(datosNuevos.getFechaNacimiento());
        datosAntiguos.setId(datosNuevos.getId());
        return profesorRepository.save(datosAntiguos);
    }

    public void EliminarProfesor(Long id){
        profesorRepository.deleteById(id);
    }
}