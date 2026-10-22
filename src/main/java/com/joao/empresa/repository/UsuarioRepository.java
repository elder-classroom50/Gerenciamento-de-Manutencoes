package com.joao.empresa.repository;

import com.joao.empresa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository
        extends JpaRepository<Usuario, Integer> {

    boolean existsByEmail(String email);
}