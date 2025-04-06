package com.rollerspeed.v1.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import com.rollerspeed.v1.Model.ERole;
import com.rollerspeed.v1.Model.RolEntity;
import com.rollerspeed.v1.Repository.RoleRespositorio;

@Component
public class IniciarRoles implements CommandLineRunner {

    @Autowired
    private RoleRespositorio roleRespositorio;

    @Override
    public void run(String... args) throws Exception {
        if (!roleRespositorio.findByName(ERole.ESTUDIANTE).isPresent()) {
            RolEntity estudianteRol = new RolEntity();
            estudianteRol.setName(ERole.ESTUDIANTE);
            roleRespositorio.save(estudianteRol);
        }

        if (!roleRespositorio.findByName(ERole.PROFESOR).isPresent()) {
            RolEntity profesorRol = new RolEntity();
            profesorRol.setName(ERole.PROFESOR);
            roleRespositorio.save(profesorRol);
        }

        if (!roleRespositorio.findByName(ERole.ADMIN).isPresent()) {
            RolEntity adminRol = new RolEntity();
            adminRol.setName(ERole.ADMIN);
            roleRespositorio.save(adminRol);
        }
    }
    
}
