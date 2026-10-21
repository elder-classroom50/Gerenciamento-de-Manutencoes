package com.joao.empresa.repository;

import com.joao.empresa.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository
        extends JpaRepository<Empresa, Integer> {

    boolean existsByCnpj(String cnpj);
}