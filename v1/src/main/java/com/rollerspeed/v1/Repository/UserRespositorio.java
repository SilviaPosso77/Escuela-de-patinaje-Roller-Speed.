package com.rollerspeed.v1.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rollerspeed.v1.Model.UserEntity;

@Repository
public interface UserRespositorio extends JpaRepository<UserEntity, Long> {

    Optional <UserEntity> findByUsername(String username);

}
