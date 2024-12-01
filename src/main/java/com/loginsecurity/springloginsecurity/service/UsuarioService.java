package com.loginsecurity.springloginsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.loginsecurity.springloginsecurity.model.Usuario;
import com.loginsecurity.springloginsecurity.repository.UsuarioRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class UsuarioService {
@Autowired private UsuarioRepository repository;
@Autowired private PasswordEncoder encoder;
private String passwordPlain;
@Transactional
public void cadastro(Usuario entity){
if(repository.existsByEmail(entity.getEmail())){
throw new EntityExistsException("Entidade já existe");
}
entity.setPassword(encoder.encode(entity.getPassword()));
repository.saveAndFlush(entity);
}
public boolean firstLogin( Usuario user){
    String encoded= repository.findById(repository.findIdByEmail(user.getEmail())).orElseThrow(() -> new  EntityNotFoundException("Entidade não encontrada")).getPassword();
    boolean isValid = encoder.matches(user.getPassword(), encoded);
    return repository.existsByEmail(user.getEmail()) && isValid && repository.existsById(repository.findIdByEmail(user.getEmail()));
}

public List<Usuario> getAll(){
    return repository.findAll();
}
}
