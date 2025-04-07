package com.rollerspeed.v1.security;

import com.rollerspeed.v1.Model.entity.Usuario;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
public interface IUsuarioDAO {
    Usuario findByUsername(String username);
}