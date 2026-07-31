package com.univo.backend_app.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    // Debe tener al menos 32 caracteres
    private static final String SECRET =
            "mi_clave_super_secreta_para_el_proyecto_saas_2026";

    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String email){

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(
                        System.currentTimeMillis() + 1000 * 60 * 60
                )) // 1 hora
                .signWith(key)
                .compact();

    }

}