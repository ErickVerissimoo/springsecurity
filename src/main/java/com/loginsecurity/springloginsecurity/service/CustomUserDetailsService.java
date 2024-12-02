package com.loginsecurity.springloginsecurity.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.loginsecurity.springloginsecurity.model.Usuario;
import com.loginsecurity.springloginsecurity.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    private UsuarioRepository repository;
    @Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Usuario entity = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    return User.withUsername(entity.getEmail()).password(entity.getPassword()).roles(entity.getRole()).build();
}
}
