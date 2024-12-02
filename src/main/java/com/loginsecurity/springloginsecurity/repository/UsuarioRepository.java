package com.loginsecurity.springloginsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.loginsecurity.springloginsecurity.model.*;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
boolean existsByEmail(String email);
boolean existsByPassword(String password);
@Query("SELECT u.id FROM Usuario u WHERE u.email = ?1")
Integer findIdByEmail(String email);
Optional<Usuario> findByEmail(String email);
}
