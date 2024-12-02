package com.loginsecurity.springloginsecurity.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Entity
@Table(name =  "usuarios")
@Data
@DynamicInsert
@DynamicUpdate
public class Usuario {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    @Email(message = "Email inválido")
    private String email;
    @Size(min = 10, message = "a senha deve ter ao menos 10 caracteres")
    @Pattern(regexp = "^(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?=(?:[^0-9]*[0-9][^0-9]*){2})(?=.*[A-Z]).+$")
    private String password;
    private String session_id;
    private String role;
}
