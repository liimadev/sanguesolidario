package com.liimadev.sanguesolidario.services;

import com.liimadev.sanguesolidario.configs.AuthConfig;
import com.liimadev.sanguesolidario.configs.TokenConfig;
import com.liimadev.sanguesolidario.dtos.LoginDTO;
import com.liimadev.sanguesolidario.dtos.UsuarioDTO;
import com.liimadev.sanguesolidario.exceptions.EmailEmUsoException;
import com.liimadev.sanguesolidario.exceptions.UsuarioNaoEncontradoException;
import com.liimadev.sanguesolidario.models.Endereco;
import com.liimadev.sanguesolidario.models.Sexo;
import com.liimadev.sanguesolidario.models.TipoSanguineo;
import com.liimadev.sanguesolidario.models.Usuario;
import com.liimadev.sanguesolidario.repositories.SexoRepository;
import com.liimadev.sanguesolidario.repositories.TipoSanguineoRepository;
import com.liimadev.sanguesolidario.repositories.UsuarioRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SexoRepository sexoRepository;
    @Autowired
    private TipoSanguineoRepository tipoSanguineoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenConfig tokenConfig;
    @Autowired
    private AuthConfig authConfig;

    public ResponseEntity<?> criar(UsuarioDTO dto) {
        if(usuarioRepository.existsByEmail(dto.email()))
            throw new EmailEmUsoException("O email inserido já está cadastrado.");

        Sexo sexo = sexoRepository.findById(dto.sexoId())
                .orElseThrow(() -> new RuntimeException("Sexo indefinido"));
        TipoSanguineo tipo = tipoSanguineoRepository.findById(dto.tipoSangueId())
                .orElseThrow(() -> new RuntimeException("Tipo Sanguíneo indefinido"));

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setCpf(dto.cpf());
        usuario.setNascimento(dto.nascimento());
        usuario.setSexo(sexo);
        usuario.setTipoSanguineo(tipo);
        usuario.setEndereco(new Endereco(
                0,
                dto.endereco().getLogradouro(),
                dto.endereco().getNumero(),
                dto.endereco().getCidade(),
                dto.endereco().getEstado(),
                dto.endereco().getCep()
        ));
        usuario.setEmail(dto.email());
        usuario.setTelefone(dto.telefone());
        usuario.setSenha(passwordEncoder.encode(dto.senha()));
        usuarioRepository.save(usuario);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Usuário cadastrado com sucesso!");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<?> login (LoginDTO dto, HttpServletResponse response) {
        Usuario usuario = usuarioRepository.findByEmail(dto.email())
                .orElseThrow(() -> new UsuarioNaoEncontradoException("O usuário não foi localizado."));
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.email(), dto.senha())
        );

        Map<String, String> retorno = new LinkedHashMap<>();
        retorno.put("token", tokenConfig.gerarToken(usuario));
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
}
