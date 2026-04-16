package com.liimadev.sanguesolidario.controllers;

import com.liimadev.sanguesolidario.dtos.UsuarioDTO;
import com.liimadev.sanguesolidario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<?> criar (@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.criar(usuarioDTO);
    }
}
