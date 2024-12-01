package com.loginsecurity.springloginsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loginsecurity.springloginsecurity.model.Usuario;
import com.loginsecurity.springloginsecurity.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AutenticationService {
@Autowired private UsuarioRepository repository;
@Autowired private PasswordEncoder encoder;
@Autowired private SessionService service;
@Transactional
public boolean authenticate(Usuario user, HttpServletResponse response){
  String session = service.secondLogin(user);
  String encoded= repository.findById(repository.findIdByEmail(user.getEmail())).orElseThrow(() -> new  EntityNotFoundException("Entidade não encontrada")).getPassword();
  if(encoder.matches(user.getPassword(), encoded)){
    repository.saveAndFlush(user);
    SetCookie(response, "session_id", session);
    return true;
  }
  return false;
}


private void SetCookie(HttpServletResponse response, String id, String value){
Cookie cook = new Cookie(id, value);
cook.setHttpOnly(true);
cook.setMaxAge(50*50);
response.addCookie(cook);
}
}
