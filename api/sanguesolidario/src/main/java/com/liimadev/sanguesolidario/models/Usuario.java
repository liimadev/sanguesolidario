package com.liimadev.sanguesolidario.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String nome;
    private String cpf;
    private Date nascimento;

    @ManyToOne
    @JoinColumn(name = "sexoId")
    private Sexo sexo;

    @ManyToOne
    @JoinColumn(name = "tipoSanguineoId")
    private TipoSanguineo tipoSanguineo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enderecoId")
    private Endereco endereco;
    private String email;
    private String telefone;
    private String senha;
}
