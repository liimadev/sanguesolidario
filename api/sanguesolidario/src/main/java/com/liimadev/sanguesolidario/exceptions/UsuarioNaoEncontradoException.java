package com.liimadev.sanguesolidario.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException (String mensagem) {
        super(mensagem);
    }
}
