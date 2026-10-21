package com.joao.empresa.service;

import com.joao.empresa.exceptions.EmpresaJaCadastradaException;
import com.joao.empresa.model.Empresa;
import com.joao.empresa.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Transactional
    public Empresa cadastrar(
            String nome,
            String cnpj,
            String endereco,
            String segmento,
            Empresa.Status status
    ) {

        if (empresaRepository.existsByCnpj(cnpj)) {

            throw new EmpresaJaCadastradaException(
                    "Já existe uma empresa cadastrada com o CNPJ "
                            + cnpj + "."
            );
        }

        Empresa empresa = new Empresa(
                nome,
                cnpj,
                endereco,
                segmento,
                status
        );

        return empresaRepository.save(empresa);
    }
}