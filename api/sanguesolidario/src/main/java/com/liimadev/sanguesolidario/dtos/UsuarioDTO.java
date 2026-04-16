package com.liimadev.sanguesolidario.dtos;

import com.liimadev.sanguesolidario.models.Endereco;

import java.sql.Date;

public record UsuarioDTO(
        String nome,
        String cpf,
        Date nascimento,
        int sexoId,
        int tipoSangueId,
        Endereco endereco,
        String email,
        String telefone,
        String senha
) {
}
