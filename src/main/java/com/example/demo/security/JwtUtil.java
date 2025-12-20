package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.Date;

public class JwtUtil {

    private final String secret;
    private final long validityInMs;

    public JwtUtil(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    public String generateToken(Long userId, String email, String role) {

        Claims claims = Jwts.claims();
        claims.put("userId", userId);
        claims.put("email", email);
        claims.put("role", role);

        long now = System.currentTimeMillis();
        Date validity = new Date(now + validityInMs);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(now))
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}
