package com.joao.empresa.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
        name = "equipamento",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_equipamento_codigo_patrimonio",
                        columnNames = "codigo_patrimonio"
                )
        }
)
public class Equipamento extends Entidade {

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(
            name = "codigo_patrimonio",
            nullable = false,
            length = 100
    )
    private String codigoPatrimonio;

    @Column(
            name = "data_aquisicao",
            nullable = false
    )
    private LocalDate dataAquisicao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "empresa_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_equipamento_empresa"
            )
    )
    private Empresa empresa;

    public Equipamento(
            String nome,
            String codigoPatrimonio,
            LocalDate dataAquisicao,
            Empresa empresa
    ) {
        this.nome = nome;
        this.codigoPatrimonio = codigoPatrimonio;
        this.dataAquisicao = dataAquisicao;
        this.empresa = empresa;
    }
}