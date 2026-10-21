package com.joao.empresa.controller;

import com.joao.empresa.dto.empresa.EmpresaRequest;
import com.joao.empresa.dto.empresa.EmpresaResponse;
import com.joao.empresa.model.Empresa;
import com.joao.empresa.service.EmpresaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<EmpresaResponse> cadastrar(
            @Valid @RequestBody EmpresaRequest request
    ) {

        Empresa empresa =
                empresaService.cadastrar(
                        request.nome(),
                        request.cnpj(),
                        request.endereco(),
                        request.segmento(),
                        request.status()
                );

        URI location =
                URI.create(
                        "/api/empresas/" + empresa.getId()
                );

        return ResponseEntity
                .created(location)
                .body(EmpresaResponse.from(empresa));
    }
}