package com.rollerspeed.v1.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rollerspeed.v1.DTO.EstudianteDTO;
import com.rollerspeed.v1.Model.ERole;
import com.rollerspeed.v1.Model.Estudiante;
import com.rollerspeed.v1.Model.RolEntity;
import com.rollerspeed.v1.Model.UserEntity;
import com.rollerspeed.v1.Model.Clase;
import com.rollerspeed.v1.Repository.ClaseRepositorio;
import com.rollerspeed.v1.Repository.EstudianteRepository;
import com.rollerspeed.v1.Repository.RoleRespositorio;
import com.rollerspeed.v1.Repository.UserRespositorio;

import jakarta.transaction.Transactional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private UserRespositorio userRespositorio;

    @Autowired
    private RoleRespositorio roleRespositorio;

    @Autowired
    private ClaseRepositorio claseRepositorio;

    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Transactional
    public void registrarEstudiante(EstudianteDTO estudianteDTO) {

        Clase clase = claseRepositorio.findById(estudianteDTO.getIdClase()).get();

        Estudiante estudiante = Estudiante.builder()
                                .id(estudianteDTO.getId())
                                .nombre(estudianteDTO.getNombre())
                                .apellido(estudianteDTO.getApellido())
                                .fechaNacimiento(estudianteDTO.getFechaNacimiento())
                                .genero(estudianteDTO.getGenero())
                                .clase(clase)
                                .build();
        UserEntity user = UserEntity.builder()
                        .username(estudianteDTO.getEmail()) //Asigna el email como nombre de usuario
                        .password(estudianteDTO.getContraseña())
                        .roles(obtenerRol())
                        .build();
                
        userRespositorio.save(user); //Guarda el usuario
        estudiante.setUser(user); //Relaciona el usuario con el estudiante
        estudianteRepository.save(estudiante);
    }

    private Set<RolEntity> obtenerRol(){
        //Logica para asignar el rol de Estudiante
        RolEntity rolEstudiante = roleRespositorio.findByName(ERole.ESTUDIANTE)
        .orElseThrow(()-> new RuntimeException("Rol ESTUDIANTE no encontrado")); //En caso de que el Rol Estudiante no exista
        Set<RolEntity> roles = new HashSet<>();
        roles.add(rolEstudiante);
        return roles;
    }
    
    public Estudiante ObtenerId(Long Id){
        return estudianteRepository.findById(Id).get();
    }

    public Estudiante ActualizarEstudiante(Estudiante datosAntiguos, Estudiante datosNuevos){
        datosAntiguos.setNombre(datosNuevos.getNombre());
        datosAntiguos.setApellido(datosNuevos.getApellido());
        datosAntiguos.setClase(datosNuevos.getClase());
        datosAntiguos.setGenero(datosNuevos.getGenero());
        datosAntiguos.setFechaNacimiento(datosNuevos.getFechaNacimiento());
        datosAntiguos.setId(datosNuevos.getId());
        return estudianteRepository.save(datosAntiguos);
    }

    public void EliminarEstudiante(Long id){
        estudianteRepository.deleteById(id);
    }
}
