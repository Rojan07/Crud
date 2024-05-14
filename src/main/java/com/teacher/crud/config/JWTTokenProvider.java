package com.teacher.crud.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTokenProvider {

    public String createToken(Authentication authentication) {
        String username = authentication.getName();
        Date date = new Date();
        Date expiration = new Date(date.getTime() + Constants.JWT_EXPIRE);

        String token = Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(expiration)
            .signWith(SignatureAlgorithm.HS512,Constants.JWT_SECRET)
            .compact();

            return token;

    }

    public String userNameFromToken(String token) {
        Claims claims = Jwts.parser()
            .setSigningKey(Constants.JWT_SECRET)
            .parseClaimsJws(token)
            .getBody();

            return claims.getSubject();
    }

    public boolean validateToken(String token) {
    try {
        Jwts.parser().setSigningKey(Constants.JWT_SECRET).parseClaimsJws(token);
        return true;
    }catch (Exception e){
        throw  new AuthenticationCredentialsNotFoundException("JWT is Expired or incorrect");
    }

    }
}
