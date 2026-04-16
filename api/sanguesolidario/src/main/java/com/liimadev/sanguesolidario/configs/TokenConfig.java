package com.liimadev.sanguesolidario.configs;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.liimadev.sanguesolidario.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenConfig {

    @Value("${JWT_SECRET}")
    private String SECRET;

    public String gerarToken (Usuario usuario) {
        return JWT.create()
                .withClaim("usuarioId", usuario.getId().toString())
                .withSubject(usuario.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .sign(Algorithm.HMAC256(SECRET));
    }

    public String validarToken (String token) {
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET))
                    .build()
                    .verify(token);

            return decodedJWT.getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }
}
