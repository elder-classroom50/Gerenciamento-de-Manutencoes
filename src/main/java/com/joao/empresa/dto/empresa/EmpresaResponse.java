package com.joao.empresa.dto.empresa;

import com.joao.empresa.model.Empresa;

public record EmpresaResponse(

        Integer id,
        String nome,
        String cnpj,
        String endereco,
        String segmento,
        Empresa.Status status

) {

    public static EmpresaResponse from(Empresa empresa) {

        return new EmpresaResponse(
                empresa.getId(),
                empresa.getNome(),
                empresa.getCnpj(),
                empresa.getEndereco(),
                empresa.getSegmento(),
                empresa.getStatus()
        );
    }
}