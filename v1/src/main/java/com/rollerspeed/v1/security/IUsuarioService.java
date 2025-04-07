package com.rollerspeed.v1.security;

import org.springframework.stereotype.Service;

import com.rollerspeed.v1.Model.entity.Usuario;

@Service
public interface IUsuarioService {
    public Usuario findByUsername(String username);
    public Usuario registrar(Usuario usuario);
}
