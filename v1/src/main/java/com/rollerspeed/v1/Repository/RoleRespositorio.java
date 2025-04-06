package com.rollerspeed.v1.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rollerspeed.v1.Model.RolEntity;
import com.rollerspeed.v1.Model.ERole;


@Repository
public interface RoleRespositorio extends JpaRepository<RolEntity,Long> {
    
    Optional <RolEntity> findByName(ERole name);
}
