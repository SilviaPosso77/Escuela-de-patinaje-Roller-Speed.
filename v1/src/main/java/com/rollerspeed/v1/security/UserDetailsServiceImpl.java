 package com.rollerspeed.v1.security;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.autoconfigure.AutoConfigureOrder;
 import org.springframework.security.core.authority.SimpleGrantedAuthority;
 import org.springframework.security.core.userdetails.User;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.core.userdetails.UsernameNotFoundException;
 import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.rollerspeed.v1.Model.entity.Usuario;

@Service
 @SuppressWarnings("unused")
public class UserDetailsServiceImpl implements UserDetailsService{

     @Autowired
     private IUsuarioDAO usuarioDAO;

     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Usuario usuario = usuarioDAO.findByUsername(username);
         UserBuilder builder = null;

         if(usuario != null){
             builder = User.withUsername(username);
             builder.disabled(false);
             builder.password(usuario.getpassword());
             builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
         }
         else{
             throw new UsernameNotFoundException("Usuario no encontrado");
         }
         return builder.build();
     }
    
 }
