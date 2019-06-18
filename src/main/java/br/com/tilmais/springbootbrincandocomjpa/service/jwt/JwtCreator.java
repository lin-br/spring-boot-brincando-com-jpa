package br.com.tilmais.springbootbrincandocomjpa.service.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

public class JwtCreator {

    private String nameOfListGrantedAuthority;
    private String keySecret;

    public JwtCreator(String nameOfListGrantedAuthority, String keySecret) {
        this.nameOfListGrantedAuthority = nameOfListGrantedAuthority;
        this.keySecret = keySecret;
    }

    public String getJwt(String sub, Date exp, Collection<? extends GrantedAuthority> authorityList) {
        Claims claims = Jwts
                .claims()
                .setIssuedAt(new Date())
                .setExpiration(exp)
                .setSubject(sub);

        claims.put(this.nameOfListGrantedAuthority,
                authorityList
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList())
        );

        JwtBuilder jwtBuilder = Jwts
                .builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, this.keySecret);

        return jwtBuilder.compact();
    }
}
