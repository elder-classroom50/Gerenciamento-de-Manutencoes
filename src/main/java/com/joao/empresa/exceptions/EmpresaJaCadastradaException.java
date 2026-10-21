package com.joao.empresa.exceptions;

public class EmpresaJaCadastradaException
        extends RuntimeException {

    public EmpresaJaCadastradaException(String mensagem) {
        super(mensagem);
    }
}