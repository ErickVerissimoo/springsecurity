package com.loginsecurity.springloginsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.session.jdbc.JdbcIndexedSessionRepository;
import org.springframework.stereotype.Service;

import com.loginsecurity.springloginsecurity.model.Usuario;

@Service
public class SessionService {
    @Autowired private JdbcIndexedSessionRepository repository;
    @Autowired private UsuarioService userserv;
    public String secondLogin( Usuario user){
        if(user.getSession_id()==null && userserv.firstLogin(user)){
            Session sessao = repository.createSession();
            user.setSession_id(sessao.getId());
            return user.getSession_id();
        }
        throw new IllegalStateException("Sessão já criada");
    }
}
