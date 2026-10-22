package com.joao.empresa.controller;

import com.joao.empresa.dto.usuario.*;
import com.joao.empresa.model.Administrador;
import com.joao.empresa.model.Gestor;
import com.joao.empresa.model.Tecnico;
import com.joao.empresa.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/administradores")
    public ResponseEntity<UsuarioResponse> cadastrarAdministrador(
            @Valid @RequestBody AdministradorRequest request
    ) {

        Administrador administrador =
                usuarioService.cadastrarAdministrador(
                        request.nome(),
                        request.email(),
                        request.departamento()
                );

        URI location =
                URI.create("/api/usuarios/" + administrador.getId());

        return ResponseEntity
                .created(location)
                .body(UsuarioResponse.from(administrador));
    }

    @PostMapping("/gestores")
    public ResponseEntity<UsuarioResponse> cadastrarGestor(
            @Valid @RequestBody GestorRequest request
    ) {

        Gestor gestor =
                usuarioService.cadastrarGestor(
                        request.nome(),
                        request.email(),
                        request.areaResponsavel()
                );

        URI location =
                URI.create("/api/usuarios/" + gestor.getId());

        return ResponseEntity
                .created(location)
                .body(UsuarioResponse.from(gestor));
    }

    @PostMapping("/tecnicos")
    public ResponseEntity<UsuarioResponse> cadastrarTecnico(
            @Valid @RequestBody TecnicoRequest request
    ) {

        Tecnico tecnico =
                usuarioService.cadastrarTecnico(
                        request.nome(),
                        request.email(),
                        request.especialidade()
                );

        URI location =
                URI.create("/api/usuarios/" + tecnico.getId());

        return ResponseEntity
                .created(location)
                .body(UsuarioResponse.from(tecnico));
    }
}