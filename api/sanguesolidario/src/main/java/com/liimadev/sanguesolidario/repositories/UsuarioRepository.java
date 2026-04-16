package com.liimadev.sanguesolidario.repositories;

import com.liimadev.sanguesolidario.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Boolean existsByEmail (String email);

    Optional<Usuario> findByEmail(String email);
}
