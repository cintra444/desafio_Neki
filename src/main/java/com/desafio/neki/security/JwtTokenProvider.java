package com.desafio.neki.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

  @Value("${jwt.secret}")
  private String secretKey;

  @Value("${jwt.expiration}")
    private Long validityInMilliseconds;

  private Key getSigningKey() {
      byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
      return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
  }

  public String createToken(String username, String role){
      Claims claims = Jwts.claims().setSubject(username);
      claims.put("role", role);

      Date now = new Date();
      Date validity = new Date(now.getTime() + validityInMilliseconds);
      return Jwts.builder()
              .setClaims(claims)
              .setIssuedAt(now)
              .setExpiration(validity)
              .signWith(getSigningKey(), SignatureAlgorithm.HS256)
              .compact();
  }

  public String getUsername(String token) {
      return getClaims(token).getSubject();

  }

  public boolean validateToken(String token) {
      try {
          getClaims(token);
          return true;
      } catch (JwtException | IllegalArgumentException e) {
          return false;
      }
  }

  private Claims getClaims(String token) {
      return Jwts.parserBuilder()
              .setSigningKey(getSigningKey())
              .build()
              .parseClaimsJws(token)
              .getBody();
  }
}
