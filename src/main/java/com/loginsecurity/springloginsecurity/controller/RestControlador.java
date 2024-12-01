package com.loginsecurity.springloginsecurity.controller;

import org.springframework.web.bind.annotation.RestController;

import com.loginsecurity.springloginsecurity.model.Usuario;
import com.loginsecurity.springloginsecurity.service.AutenticationService;
import com.loginsecurity.springloginsecurity.service.UsuarioService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class RestControlador {
    @Autowired private UsuarioService service;
    @Autowired private AutenticationService auth;
@PostMapping(value = "cadastrar")
@ResponseStatus(code = HttpStatus.CREATED)
public String cadastrar(@Valid @RequestBody Usuario user) {    
    service.cadastro(user);
    
    return "Usuário cadastrado";
}
@PostMapping("login")
public String login(@RequestBody Usuario entity, HttpServletResponse response) {
    return auth.authenticate(entity, response)? "Usuario logado com sucesso" : "Erro no login";

}
@GetMapping("GetAll")
public List<Usuario> getAll() {
    return service.getAll();
}

}