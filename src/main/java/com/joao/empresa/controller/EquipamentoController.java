package com.joao.empresa.controller;

import com.joao.empresa.dto.equipamento.EquipamentoRequest;
import com.joao.empresa.dto.equipamento.EquipamentoResponse;
import com.joao.empresa.model.Equipamento;
import com.joao.empresa.service.EquipamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/equipamentos")
@RequiredArgsConstructor
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    @PostMapping
    public ResponseEntity<EquipamentoResponse> cadastrar(
            @Valid @RequestBody EquipamentoRequest request
    ) {

        Equipamento equipamento =
                equipamentoService.cadastrar(
                        request.nome(),
                        request.codigoPatrimonio(),
                        request.dataAquisicao(),
                        request.empresaId()
                );

        URI location =
                URI.create(
                        "/api/equipamentos/"
                                + equipamento.getId()
                );

        return ResponseEntity
                .created(location)
                .body(EquipamentoResponse.from(equipamento));
    }
}