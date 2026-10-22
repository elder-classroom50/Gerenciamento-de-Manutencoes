package com.joao.empresa.service;

import com.joao.empresa.exceptions.EmpresaNaoEncontradaException;
import com.joao.empresa.exceptions.EquipamentoJaCadastradoException;
import com.joao.empresa.exceptions.EquipamentoNaoEncontradoException;
import com.joao.empresa.model.Empresa;
import com.joao.empresa.model.Equipamento;
import com.joao.empresa.repository.EmpresaRepository;
import com.joao.empresa.repository.EquipamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;
    private final EmpresaRepository empresaRepository;

    @Transactional
    public Equipamento cadastrar(
            String nome,
            String codigoPatrimonio,
            LocalDate dataAquisicao,
            Integer empresaId
    ) {

        if (equipamentoRepository
                .existsByCodigoPatrimonio(codigoPatrimonio)) {

            throw new EquipamentoJaCadastradoException(
                    "Já existe um equipamento cadastrado "
                            + "com o código de patrimônio "
                            + codigoPatrimonio
                            + "."
            );
        }

        Empresa empresa = empresaRepository
                .findById(empresaId)
                .orElseThrow(
                        () -> new EmpresaNaoEncontradaException(
                                "Empresa com ID "
                                        + empresaId
                                        + " não encontrada."
                        )
                );

        Equipamento equipamento =
                new Equipamento(
                        nome,
                        codigoPatrimonio,
                        dataAquisicao,
                        empresa
                );

        return equipamentoRepository.save(equipamento);
    }

    @Transactional(readOnly = true)
    public Equipamento buscarPorId(Integer id) {

        return equipamentoRepository.findById(id)
                .orElseThrow(
                        () -> new EquipamentoNaoEncontradoException(
                                "Equipamento com ID "
                                        + id
                                        + " não encontrado."
                        )
                );
    }

    @Transactional(readOnly = true)
    public List<Equipamento> listar() {

        return equipamentoRepository.findAll(
                Sort.by(Sort.Direction.ASC, "id")
        );
    }

}