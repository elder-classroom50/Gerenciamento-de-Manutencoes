package com.joao.empresa.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tecnico")
@PrimaryKeyJoinColumn(
        name = "usuario_id",
        foreignKey = @ForeignKey(name = "fk_tecnico_usuario")
)
@DiscriminatorValue("TECNICO")
public class Tecnico extends Usuario {

    @Column(nullable = false, length = 100)
    private String especialidade;

    public Tecnico(
            String nome,
            String email,
            String especialidade
    ) {
        super(nome, email);
        this.especialidade = especialidade;
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.TECNICO;
    }
}