package com.loginsecurity.springloginsecurity.controller;

import org.springframework.web.bind.annotation.RestController;

import com.loginsecurity.springloginsecurity.model.Usuario;
import com.loginsecurity.springloginsecurity.service.UsuarioService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping(path = "public")
public class publicController {
    @Autowired private UsuarioService service;
    @PostMapping(value = "cadastrar")
@ResponseStatus(code = HttpStatus.CREATED)
public String cadastrar(@Valid @RequestBody Usuario user) {    
    service.cadastro(user);
    
    return "Usuário cadastrado";
}

@GetMapping("GetAll")
public List<Usuario> getAll() {
    return service.getAll();
}

}