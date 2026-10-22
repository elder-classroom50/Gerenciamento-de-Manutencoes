package com.joao.empresa.service;

import com.joao.empresa.exceptions.UsuarioJaCadastradoException;
import com.joao.empresa.model.Administrador;
import com.joao.empresa.model.Gestor;
import com.joao.empresa.model.Tecnico;
import com.joao.empresa.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private void validarEmailDisponivel(String email) {

        if (usuarioRepository.existsByEmail(email)) {

            throw new UsuarioJaCadastradoException(
                    "Já existe um usuário cadastrado com o e-mail "
                            + email + "."
            );
        }
    }

    @Transactional
    public Administrador cadastrarAdministrador(
            String nome,
            String email,
            String departamento
    ) {

        validarEmailDisponivel(email);

        Administrador administrador =
                new Administrador(
                        nome,
                        email,
                        departamento
                );

        return usuarioRepository.save(administrador);
    }

    @Transactional
    public Gestor cadastrarGestor(
            String nome,
            String email,
            String areaResponsavel
    ) {

        validarEmailDisponivel(email);

        Gestor gestor =
                new Gestor(
                        nome,
                        email,
                        areaResponsavel
                );

        return usuarioRepository.save(gestor);
    }

    @Transactional
    public Tecnico cadastrarTecnico(
            String nome,
            String email,
            String especialidade
    ) {

        validarEmailDisponivel(email);

        Tecnico tecnico =
                new Tecnico(
                        nome,
                        email,
                        especialidade
                );

        return usuarioRepository.save(tecnico);
    }
}